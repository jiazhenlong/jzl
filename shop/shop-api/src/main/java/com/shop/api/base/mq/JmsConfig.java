package com.shop.api.base.mq;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

/**  
*
* @Title:  JmsConfig.java   
* @Package com.shop.api.service   
* @Description:    TODO(mq监听配置类)   
* @author: jiazhenlong     
* @date:   2018年5月29日 下午5:49:37   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Configuration
@EnableJms
public class JmsConfig {

  
  /**
   * 
   * @date:   2018年5月30日 上午9:35:41  
   * @Title: jmsListenerContainerTopic   
   * @Description: TODO(topic模式的ListenerContainer)   
   * @param activeMQConnectionFactory
   * @return      
   * @return: JmsListenerContainerFactory<?>       
   *
   */
  @Bean
  public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
      DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
      bean.setPubSubDomain(true);
      bean.setConnectionFactory(activeMQConnectionFactory);
      return bean;
  }
  /**
   * 
   * @date:   2018年5月30日 上午9:35:56  
   * @Title: jmsListenerContainerQueue   
   * @Description: TODO(queue模式的ListenerContainer)   
   * @param activeMQConnectionFactory
   * @return      
   * @return: JmsListenerContainerFactory<?>       
   *
   */
  @Bean
  public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory) {
      DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
      bean.setConnectionFactory(activeMQConnectionFactory);
      return bean;
  }
}
