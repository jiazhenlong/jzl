package com.shop.task.job.actor;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.model.ShopAds;
import com.shop.service.ShopAdsCoreService;
import com.shop.task.base.akka.AsyncExecutors;
import com.shop.task.base.akka.Task;

/**  
*
* @Title:  TestActor.java   
* @Package com.shop.task.job   
* @Description:    TODO(测试akka)   
* @author: jiazhenlong     
* @date:   2018年7月11日 下午2:30:15   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Component
public class TestActor {
  private static final Logger LOG = LoggerFactory.getLogger(TestActor.class);

  @Autowired
  private ShopAdsCoreService shopAdsCoreService;
  
  @Autowired
  private AsyncExecutors<?, ?> asyncExecutors;
  
  
  
  @PostConstruct
  public void test () {
    List<ShopAds> shopAdsList = shopAdsCoreService.findShopAdsList(null, null, null, null);
    LOG.info("&&&&&&&&&&&&&:" + shopAdsList);
    
    asyncExecutors.executeWithDefault(new Task<List<ShopAds>>(shopAdsList, null, list -> execute(list)), null);
    
    asyncExecutors.executeWithProcessor(new Task<List<ShopAds>>(shopAdsList, ShopAdsActor.class));
  }
  
  
  private void execute(List<ShopAds> shopAdsList) {
    LOG.info("************:" + shopAdsList);
  }
  
  
}
