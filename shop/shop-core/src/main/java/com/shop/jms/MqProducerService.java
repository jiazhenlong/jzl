package com.shop.jms;

import java.io.Serializable;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**  
*
* @Title:  MqProducerService.java   
* @Package com.shop.jms   
* @Description:    TODO(mq消息发送)   
* @author: jiazhenlong     
* @date:   2018年5月29日 下午4:02:48   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Component
public class MqProducerService {


  @Autowired
  private JmsMessagingTemplate jmsMessagingTemplate;



  public void sendData(Destination destination, Serializable obj) {
    this.jmsMessagingTemplate.convertAndSend(destination, obj);
  }

  public void sendMessage(Destination destination, String message) {
    this.jmsMessagingTemplate.convertAndSend(destination, message);
  }

  public void sendTopicMessage(Destination destination, String message) {
    this.jmsMessagingTemplate.convertAndSend(destination, message);
  }
}
