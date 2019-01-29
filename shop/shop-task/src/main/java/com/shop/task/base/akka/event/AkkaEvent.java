package com.shop.task.base.akka.event;


/**  
*
* @Title:  AkkaEvent.java   
* @Package com.shop.task.base.akka.event  
* @Description:    TODO(akka事件)   
* @author: jiazhenlong     
* @date:   2018年7月16日 上午10:07:30   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AkkaEvent {

  
  private String type;
  
  private String message;

  public AkkaEvent(String type, String message) {
    this.type = type;
    this.message = message;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
  
  
}
