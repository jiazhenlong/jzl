package com.shop.task.job.actor;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.shop.model.ShopAds;
import com.shop.task.base.akka.SpringExtension;
import com.shop.task.base.akka.Task;
import com.shop.task.base.akka.event.AkkaEvent;
import com.shop.task.base.akka.event.AkkaLookupEventBus;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**  
*
* @Title:  ShopAdsActor.java   
* @Package com.shop.task.job.actor   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: jiazhenlong     
* @date:   2018年7月13日 上午11:55:23   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Component
@Scope("prototype")
public class ShopAdsActor extends AbstractActor {
  
  @Resource
  private ActorSystem actorSystem;
  
  @Resource
  private SpringExtension springExtension;

  @Override
  public Receive createReceive() {
    return receiveBuilder().match(Task.class, x -> {
      @SuppressWarnings("unchecked")
      List<ShopAds> shopAdsList = (List<ShopAds>) x.getMsg();
      
      for (ShopAds shopAds : shopAdsList) {
        System.out.println("hhh:" + shopAds);
      }
      
      AkkaLookupEventBus aleb = new AkkaLookupEventBus();
      
      ActorRef actorRef = actorSystem.actorOf(springExtension.props(AdsActor.class));
      
      aleb.subscribe(actorRef, "info");
      
      aleb.publish(new AkkaEvent("info", "oh no"));
      
    }).build();
  }

}
