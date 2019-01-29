package com.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.mysql.MerchantsDao;
import com.shop.model.Merchants;
import com.shop.service.MerchantsCoreService;

/**  
*
* @Title:  MerchantsCoreServiceImpl.java   
* @Package com.shop.service.impl   
* @Description:    TODO(商家)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:23:06   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class MerchantsCoreServiceImpl implements MerchantsCoreService{

  @Autowired
  private MerchantsDao merchantsDao;
  
  
  
  
  
  
  @Override
  public void addMerchants(Merchants merchants) {
    merchantsDao.addMerchants(merchants);    
  }

  @Override
  public Merchants getMerchantsById(long id) {
    return merchantsDao.getMerchantsById(id);
  }

}
