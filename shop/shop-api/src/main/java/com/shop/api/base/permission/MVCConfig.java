package com.shop.api.base.permission;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**  
*
* @Title:  MVCConfig.java   
* @Package com.shop.api.base.permission   
* @Description:    TODO(adapter)   
* @author: jiazhenlong     
* @date:   2018年7月5日 上午11:34:53   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {

  @Bean
  public AuthInterceptor authInterceptor() {
      return new AuthInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
  registry.addInterceptor(authInterceptor()).excludePathPatterns("/static/*")
              .excludePathPatterns("/error").addPathPatterns("/**");
  }
}
