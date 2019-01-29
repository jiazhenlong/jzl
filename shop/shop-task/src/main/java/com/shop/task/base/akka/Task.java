package com.shop.task.base.akka;

import akka.actor.AbstractActor;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Description
 * @Author Dong WL
 * @Date 17:19 2018/6/9.
 */
public class Task<T> {
    /**
     * 消息
     */
    private T msg;

    private Class<? extends AbstractActor> processor;

    private Function<T, Object> function;

    private Consumer<T> consumer;

    public Task(T msg, Function<T, Object> function, Consumer<T> consumer) {
        this.msg = msg;
        this.function = function;
        this.consumer = consumer;
    }

    public Task(T msg, Class<? extends AbstractActor> processor) {
        this.msg = msg;
        this.processor = processor;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }

    public Class<? extends AbstractActor> getProcessor() {
        return processor;
    }

    public void setProcessor(Class<? extends AbstractActor> processor) {
        this.processor = processor;
    }

    public Function<T, Object> getFunction() {
        return function;
    }

    public void setFunction(Function<T, Object> function) {
        this.function = function;
    }

    public Consumer<T> getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer<T> consumer) {
        this.consumer = consumer;
    }
}
