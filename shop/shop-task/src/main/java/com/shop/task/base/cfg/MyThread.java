package com.shop.task.base.cfg;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**  
*
* @Title:  MyThread.java   
* @Package com.shop.task.base.cfg   
* @Description:    TODO(线程池配置)   
* @author: jiazhenlong     
* @date:   2018年6月4日 下午2:03:41   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Configuration
@EnableAsync
public class MyThread {

  /**
   * 线程池维护线程的最少数量
   */
  private int corePoolSize = 10;

  /**
   * 线程池维护线程的最大数量
   */
  private int maxPoolSize = 50;

  /**
   * 缓存队列
   */
  private int queueCapacity = 600; 

  /**
   * 允许的空闲时间
   */
  private int keepAlive = 60;

  @Bean
  public Executor manageExecutor() {
      ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
      // 设置核心线程数
      executor.setCorePoolSize(corePoolSize);
      // 设置最大线程数
      executor.setMaxPoolSize(maxPoolSize);
      // 设置队列容量
      executor.setQueueCapacity(queueCapacity);
      // 设置默认线程名称
      executor.setThreadNamePrefix("taskExecutor-");
      
      //设置拒绝策略 ,rejection-policy：当pool已经达到max size的时候，如何处理新任务  CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行  
      executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); 
      // 设置线程活跃时间（秒）
      executor.setKeepAliveSeconds(keepAlive);
      
      // 等待所有任务结束后再关闭线程池
      executor.setWaitForTasksToCompleteOnShutdown(true);
      executor.initialize();
      return executor;
  }
}
