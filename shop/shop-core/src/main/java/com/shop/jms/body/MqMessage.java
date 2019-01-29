package com.shop.jms.body;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  MqMessage.java   
* @Package com.shop.jms.body   
* @Description:    TODO(消息对象)   
* @author: jiazhenlong     
* @date:   2018年5月25日 下午4:41:10   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class MqMessage {

  /**
   * 主题
   */
  private String destination;

  /**
   * json形式的消息
   */
  private String msgBodyJson;

  public MqMessage(){}
  

  public MqMessage(String destination, String msgBodyJson){
    this.destination = destination;
    this.msgBodyJson = msgBodyJson;
  }
  
  
  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getMsgBodyJson() {
    return msgBodyJson;
  }

  public void setMsgBodyJson(String msgBodyJson) {
    this.msgBodyJson = msgBodyJson;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
