package com.shop.task.base.akka.event;

import akka.actor.ActorRef;
import akka.event.japi.LookupEventBus;

/**  
*
* @Title:  AkkaLookupEventBus.java   
* @Package com.shop.task.base.akka.event   
* @Description:    TODO(类型事件)   
* @author: jiazhenlong     
* @date:   2018年7月16日 上午10:19:04   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AkkaLookupEventBus extends LookupEventBus<AkkaEvent, ActorRef, String>{

  @Override
  public String classify(AkkaEvent event) {
    return event.getType();
  }

  @Override
  public int compareSubscribers(ActorRef a,
                                ActorRef b) {
    return a.compareTo(b);
  }

  @Override
  public int mapSize() {
    return 8;
  }

  @Override
  public void publish(AkkaEvent event,
                      ActorRef ref) {

    ref.tell(event.getMessage(), ActorRef.noSender());
  }

}
