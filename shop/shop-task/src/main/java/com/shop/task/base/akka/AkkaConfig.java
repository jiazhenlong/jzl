package com.shop.task.base.akka;

import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Dong WL
 * @Date 15:14 2018/6/9.
 */
@Configuration
public class AkkaConfig {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private SpringExtension springExtension;


    @Bean
    public ActorSystem actorSystems() {
        ActorSystem actorSystem = ActorSystem.create("ActorSystem");
        springExtension.initialize(applicationContext);
        return actorSystem;
    }

    @Bean
    public Config akkaConfigs() {
        return ConfigFactory.load();
    }


}
