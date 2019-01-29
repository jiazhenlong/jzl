package com.shop.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@EnableAsync
@ComponentScan("com.shop")
@MapperScan("com.shop.dao")
public class ShopApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopApiApplication.class, args);
  }


  private CorsConfiguration buildConfig() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    // 1 设置访问源地址
    corsConfiguration.addAllowedOrigin("*");
    // 2 设置访问源请求头
    corsConfiguration.addAllowedHeader("*");
    // 3 设置访问源请求方法
    corsConfiguration.addAllowedMethod("*");
    // corsConfiguration.addExposedHeader(HttpHeaderConStant.X_TOTAL_COUNT);
    return corsConfiguration;
  }

  /**
   * 跨域过滤器
   *
   * @return
   */
  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    // 4 对接口配置跨域设置
    source.registerCorsConfiguration("/**", buildConfig());
    return new CorsFilter(source);
  }
}
