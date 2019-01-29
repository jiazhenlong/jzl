package com.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.mysql.ShopAdsDao;
import com.shop.model.ShopAds;
import com.shop.service.ShopAdsCoreService;


/**  
*
* @Title:  ShopAdsCoreServiceImpl.java   
* @Package com.shop.service.impl   
* @Description:    TODO(广告投放)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:25:41   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class ShopAdsCoreServiceImpl implements ShopAdsCoreService {
  
  @Autowired
  private ShopAdsDao shopAdsDao;
  
  

  @Override
  public void addShopAds(ShopAds shopAds) {
    shopAdsDao.addShopAds(shopAds);    
  }

  @Override
  public ShopAds getShopAdsById(long id) {
    return shopAdsDao.getShopAdsById(id);
  }

  @Override
  public void addBatchShopAds(List<ShopAds> shopAdsList) {
    shopAdsDao.addBatchShopAds(shopAdsList);    
  }

  @Override
  public List<ShopAds> findShopAdsListPage(Long adsShopId,
                                       Integer verify,
                                       Integer status,
                                       String title,
                                       int pageIndex,
                                       int pageSize) {
    return shopAdsDao.findShopAdsListPage(adsShopId, verify, status, title, pageIndex, pageSize);
  }

  @Override
  public int countShopAdsPage(Long adsShopId,
                              Integer verify,
                              Integer status,
                              String title) {
    return shopAdsDao.countShopAdsPage(adsShopId, verify, status, title);
  }

  @Override
  public List<ShopAds> findShopAdsList(Long adsShopId,
                                       Integer verify,
                                       Integer status,
                                       String title) {
    return shopAdsDao.findShopAdsList(adsShopId, verify, status, title);
  }

  @Override
  public void delShopAdsById(long id) {
    shopAdsDao.delShopAdsById(id);    
  }

  @Override
  public Optional<ShopAds> getShopAdsDetailById(long id) {
    return Optional.ofNullable(shopAdsDao.getShopAdsDetailById(id));
  }

}
