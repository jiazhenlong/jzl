package com.shop.api.base.mq;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.shop.model.Orders;

/**  
*
* @Title:  JmsListenerService.java   
* @Package com.shop.api.service   
* @Description:    TODO(mq消息接收)   
* @author: jiazhenlong     
* @date:   2018年5月29日 下午4:58:37   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class JmsListenerService {
  private static final Logger LOG = LoggerFactory.getLogger(JmsListenerService.class);



  @JmsListener(destination = "test.mq2", containerFactory = "jmsListenerContainerQueue")
  public void receiveQueueObj(ObjectMessage message) throws JMSException {
    LOG.info("----------order-----------" + message);
    LOG.info("----------message-----------" + message.getObject());
    Orders order = new Orders();

    BeanUtils.copyProperties(message.getObject(), order);

    LOG.info("order--------------" + order);
    LOG.info("order数据数据完成...");
  }

  @JmsListener(destination = "test.mq3", containerFactory = "jmsListenerContainerQueue")
  public void receiveQueueString(String message) throws JMSException {
    LOG.info("receiveQueueString--------------" + message);
  }


  @JmsListener(destination = "test.mq", containerFactory = "jmsListenerContainerTopic")
  public void receiveTopicObj(ObjectMessage message) throws JMSException {
    LOG.info("----------order-----------" + message);
    LOG.info("----------message-----------" + message.getObject());
    Orders order = new Orders();

    BeanUtils.copyProperties(message.getObject(), order);

    LOG.info("order--------------" + order);
    LOG.info("order数据数据完成...");
  }

  @JmsListener(destination = "test.mq4", containerFactory = "jmsListenerContainerTopic")
  public void receiveTopicString(String message) throws JMSException {
    LOG.info("receiveTopicString--------------" + message);
  }
}
