package com.shop.service;

import com.shop.model.Merchants;

/**  
*
* @Title:  MerchantsCoreService.java   
* @Package com.shop.service   
* @Description:    TODO(商家)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:11:28   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface MerchantsCoreService {

  /**
   * 
   * @date:   2018年6月15日 下午3:10:45  
   * @Title: addMerchants   
   * @Description: TODO(新增商家信息)   
   * @param merchants      
   * @return: void       
   *
   */
  void addMerchants(Merchants merchants);
  
  /**
   * 
   * @date:   2018年6月15日 下午3:10:51  
   * @Title: getMerchantsById   
   * @Description: TODO(根据id获取商家信息)   
   * @param id
   * @return      
   * @return: Merchants       
   *
   */
  Merchants getMerchantsById(long id);
}
