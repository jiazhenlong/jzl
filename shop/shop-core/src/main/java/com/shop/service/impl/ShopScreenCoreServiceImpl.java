package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.mysql.ShopScreenDao;
import com.shop.model.AdsScreen;
import com.shop.model.ShopScreen;
import com.shop.service.ShopScreenCoreService;


/**  
*
* @Title:  ShopScreenCoreServiceImpl.java   
* @Package com.shop.service.impl   
* @Description:    TODO(商家门店电视屏)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:26:28   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class ShopScreenCoreServiceImpl implements ShopScreenCoreService {

  @Autowired
  private ShopScreenDao shopScreenDao;
  
  
  
  

  @Override
  public void addShopScreen(ShopScreen shopScreen) {
    shopScreenDao.addShopScreen(shopScreen);;    
  }

  @Override
  public ShopScreen getShopScreenById(long id) {
    return shopScreenDao.getShopScreenById(id);
  }

  @Override
  public void delShopScreenById(long id) {
    shopScreenDao.delShopScreenById(id);    
  }

  @Override
  public void addBatchAdsScreen(List<AdsScreen> adsScreenList) {
    shopScreenDao.addBatchAdsScreen(adsScreenList);
  }
}
