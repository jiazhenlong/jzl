package com.shop.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling 
@ComponentScan("com.shop.jms, com.shop.cache, com.shop.service")
@ComponentScan("com.shop.manage.base.mq")
@MapperScan("com.shop.dao.mysql") 
public class ShopManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopManageApplication.class, args);
	}
}
