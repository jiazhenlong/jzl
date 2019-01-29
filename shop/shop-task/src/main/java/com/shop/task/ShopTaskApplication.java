package com.shop.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling 
@EnableDiscoveryClient
@ImportResource(locations={"classpath:elastic-job-config.xml"})
@ComponentScan("com.shop")
@MapperScan("com.shop.dao.mysql") 
public class ShopTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopTaskApplication.class, args);
	}
}
