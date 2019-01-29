package com.shop.task.base.akka;

import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.japi.pf.DeciderBuilder;
import scala.concurrent.duration.Duration;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Dong WL
 * @Date 19:54 2018/6/13.
 */
public class AbstractSupervisor {
    public SupervisorStrategy getSupervisorStrategy() {
        return new OneForOneStrategy(3, Duration.create(1, TimeUnit.MINUTES),
                DeciderBuilder.
                        match(ArithmeticException.class, e -> SupervisorStrategy.resume()).
                        match(NullPointerException.class, e -> SupervisorStrategy.resume()).
                        match(IllegalArgumentException.class, e -> SupervisorStrategy.resume()).
                        match(SQLException.class, e -> SupervisorStrategy.resume()).
                        matchAny(throwable -> SupervisorStrategy.stop())
                        .build()
        );
    }
}
