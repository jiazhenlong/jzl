package com.shop.task.base.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorKilledException;
import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.japi.pf.DeciderBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import scala.concurrent.duration.Duration;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 *Created by hzdongweiliang on 2017/8/21.
 */
@Component
@Scope("prototype")
public class Supervisor extends AbstractActor {

    @Resource
    private SpringExtension springExtension;

    /**
     * OneForOneStrategy 把指定行动应用到失败的子孩子上
     */
    private SupervisorStrategy supervisorStrategy = new OneForOneStrategy(3, Duration.create(1, TimeUnit.MINUTES),
            DeciderBuilder.
                    match(ArithmeticException.class, e -> SupervisorStrategy.resume()).
                    match(NullPointerException.class, e -> SupervisorStrategy.resume()).
                    match(IllegalArgumentException.class, e -> SupervisorStrategy.resume()).
                    match(SQLException.class, e -> SupervisorStrategy.resume()).
                    match(ActorKilledException.class, e -> SupervisorStrategy.stop()).
                    matchAny(throwable -> SupervisorStrategy.stop())
                    .build()
            );

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return supervisorStrategy;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Task.class, task ->
                getContext().actorOf(springExtension.props(task.getProcessor())).tell(task, getSelf()))
                .build();
    }

}
