package com.shop.task.job.actor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.AbstractActor;

/**  
*
* @Title:  AdsActor.java   
* @Package com.shop.task.job.actor   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: jiazhenlong     
* @date:   2018年7月13日 上午11:55:56   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Component
@Scope("prototype")
public class AdsActor extends AbstractActor {

  @Override
  public Receive createReceive() {
    return receiveBuilder().match(String.class, x -> {
      System.out.println(x + "******************");
    }).build();
  }

}
