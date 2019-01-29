package com.shop.service;

import java.util.Date;

import com.shop.model.MerchantShops;

/**  
*
* @Title:  MerchantShopsCoreService.java   
* @Package com.shop.service   
* @Description:    TODO(商家门店)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:13:50   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface MerchantShopsCoreService {

  
  
  
  /**
   * 
   * @date:   2018年6月15日 下午3:59:42  
   * @Title: addMerchantShops   
   * @Description: TODO(新增商家门店信息)   
   * @param merchantShops      
   * @return: void       
   *
   */
  void addMerchantShops(MerchantShops merchantShops);
  
  /**
   * 
   * @date:   2018年6月15日 下午3:59:55  
   * @Title: getMerchantShopsById   
   * @Description: TODO(根据主键获取商家门店信息)   
   * @param id
   * @return      
   * @return: MerchantShops       
   *
   */
  MerchantShops getMerchantShopsById(long id);
  
  /**
   * 
   * @date:   2018年6月22日 下午5:12:58  
   * @Title: updateMerchantShops   
   * @Description: TODO(修改商家门店)   
   * @param merchantShops      
   * @return: void       
   *
   */
  void updateMerchantShops(MerchantShops merchantShops);
  
  /**
   * 
   * @date:   2018年6月28日 下午5:01:39  
   * @Title: getPasswordByMobile   
   * @Description: TODO(根据手机号查询密码)   
   * @param mobile
   * @return      
   * @return: String       
   *
   */
  String getPasswordByMobile(String mobile);
  
  /**
   * 
   * @date:   2018年6月29日 上午11:38:07  
   * @Title: updatePassword   
   * @Description: TODO(修改密码)   
   * @param mobile
   * @param password
   * @param updatedTime      
   * @return: void       
   *
   */
  void updatePassword(String mobile, String password, Date updatedTime);
}
