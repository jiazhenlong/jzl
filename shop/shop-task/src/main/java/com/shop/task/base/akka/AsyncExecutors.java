package com.shop.task.base.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.dispatch.Futures;
import com.google.common.base.Preconditions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import scala.PartialFunction;
import scala.concurrent.Future;
import scala.runtime.BoxedUnit;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static akka.pattern.Patterns.ask;
import static scala.compat.java8.FutureConverters.toJava;

/**
 * @Description 并发处理类
 * @author Dong WL
 * @Date 20:46 2018/6/12.
 */
@Component
public class AsyncExecutors<T, R> {

    @Resource
    private ActorSystem actorSystem;

    @Resource
    private SpringExtension springExtension;

    private final static Long TIMEOUT = 1000L;

    /**
     * 指定处理类
     * @param task 消息体
     * @param timeout 执行单条消息的超时时间（在需要获取返回值时指定, 否则置空）
     */
    public Future<Object> executeWithProcessor(Task<?> task, Long timeout) {
        Preconditions.checkArgument(task.getProcessor() != null, "必须指定任务处理类");
        ActorRef actorRef = actorSystem.actorOf(springExtension.props(task.getProcessor()));
        return ask(actorRef, task, timeout == null || timeout == 0L ? TIMEOUT : timeout);
    }
    
    public void executeWithProcessor(Task<?> task) {
      Preconditions.checkArgument(task.getProcessor() != null, "必须指定任务处理类");
      ActorRef actorRef = actorSystem.actorOf(springExtension.props(task.getProcessor()));
      
      actorRef.tell(task, ActorRef.noSender());
  }

    /**
     * 没有指定处理者，使用默认的处理类
     * @param task 消息体
     * @param timeout 执行单条消息的超时时间（在需要获取返回值时指定）
     */
    public Future<Object> executeWithDefault(Task<?> task, Long timeout) {
        Preconditions.checkArgument(task.getFunction() != null || task.getConsumer() != null, "必须指定Lambda表达式！");
        ActorRef actorRef = actorSystem.actorOf(springExtension.props(DefaultActor.class));
        return ask(actorRef, task, timeout == null || timeout == 0L ? TIMEOUT : timeout);
    }

    /**
     * 指定处理任务的批量处理方法
     * @param params 消息体
     * @param processor 指定的处理任务
     * @return
     */
    public CompletionStage<?> batchWithProcessor(List<T> params, Class<? extends AbstractActor> processor) {
        List<Future<Object>> collect = params.parallelStream().map(t -> {
            ActorRef actorRef = actorSystem.actorOf(springExtension.props(processor));
            return ask(actorRef, new Task<>(t, processor), 1000);
        }).collect(Collectors.toList());
        Future<Iterable<Object>> future = Futures.sequence(collect, actorSystem.dispatcher());
        return toJava(future);
    }

    public ActorRef defaultSupervisor() {
        return actorSystem.actorOf(springExtension.props(Supervisor.class));
    }

    /**
     * 使用默认处理类的批量处理方法
     * @param params 消息体
     * @param function
     * @param consumer
     * @return
     */
    public CompletionStage<?> batchWithDefault(List<T> params, Function<T, Object> function, Consumer<T> consumer) {
        Preconditions.checkArgument(function != null || consumer != null, "必须指定Lambda表达式！");
        List<Future<Object>> collect = params.parallelStream().map(t -> {
            ActorRef actorRef = actorSystem.actorOf(springExtension.props(DefaultActor.class));
            return ask(actorRef, new Task<T>(t, function, consumer), 1000);
        }).collect(Collectors.toList());
        Future<Iterable<Object>> future = Futures.sequence(collect, actorSystem.dispatcher());
        return toJava(future);
    }

    @Component
    @Scope("prototype")
    public class DefaultActor extends AbstractActor{
        @SuppressWarnings("unchecked")
        @Override
        public Receive createReceive() {
            return receiveBuilder().match(Task.class, x -> {
                if (null != x.getFunction()) {
                    Object apply = x.getFunction().apply(x.getMsg());
                    sender().tell(apply, self());
                }

                if (null != x.getConsumer()) {
                    x.getConsumer().accept(x.getMsg());
                }
            }).build();
        }

        @Override
        public void aroundReceive(PartialFunction<Object, BoxedUnit> receive, Object msg) {
            //任务完成后销毁
            getContext().stop(getSelf());
            super.aroundReceive(receive, msg);
        }
    }
}
