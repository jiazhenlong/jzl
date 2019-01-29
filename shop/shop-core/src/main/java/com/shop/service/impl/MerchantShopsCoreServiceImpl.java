package com.shop.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.aspect.ImportES;
import com.shop.dao.mysql.MerchantShopsDao;
import com.shop.model.MerchantShops;
import com.shop.service.MerchantShopsCoreService;


/**  
*
* @Title:  MerchantShopsCoreServiceImpl.java   
* @Package com.shop.service.impl   
* @Description:    TODO(商家门店)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:22:19   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class MerchantShopsCoreServiceImpl implements MerchantShopsCoreService {

  @Autowired
  private MerchantShopsDao merchantShopsDao;
  
  
  
  @Override
  public void addMerchantShops(MerchantShops merchantShops) {
    merchantShopsDao.addMerchantShops(merchantShops);
  }

  @Override
  public MerchantShops getMerchantShopsById(long id) {
    return merchantShopsDao.getMerchantShopsById(id);
  }

  @Override
  @ImportES
  public void updateMerchantShops(MerchantShops merchantShops) {
    merchantShopsDao.updateMerchantShops(merchantShops);
  }

  @Override
  public String getPasswordByMobile(String mobile) {
    return merchantShopsDao.getPasswordByMobile(mobile);
  }

  @Override
  public void updatePassword(String mobile,
                             String password,
                             Date updatedTime) {
    merchantShopsDao.updatePassword(mobile, password, updatedTime);    
  }

}
