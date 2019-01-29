package com.shop.service;

import java.util.List;

import com.shop.model.AdsScreen;
import com.shop.model.ShopScreen;

/**  
*
* @Title:  ShopScreenCoreService.java   
* @Package com.shop.service   
* @Description:    TODO(商家门店电视屏)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:16:19   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface ShopScreenCoreService {

  /**
   * 
   * @date:   2018年6月26日 上午9:48:58  
   * @Title: addShopScreen   
   * @Description: TODO(新增商家门店电视屏)   
   * @param shopScreen      
   * @return: void       
   *
   */
  void addShopScreen(ShopScreen shopScreen);
  
  /**
   * 
   * @date:   2018年6月26日 上午9:49:10  
   * @Title: getShopScreenById   
   * @Description: TODO(根据主键获取商家门店电视屏)   
   * @param id
   * @return      
   * @return: ShopScreen       
   *
   */
  ShopScreen getShopScreenById(long id);
  
  /**
   * 
   * @date:   2018年6月26日 上午9:49:23  
   * @Title: delShopScreenById   
   * @Description: TODO(根据主键删除商家门店电视屏)   
   * @param id      
   * @return: void       
   *
   */
  void delShopScreenById(long id);
  
  /**
   * 
   * @date:   2018年6月26日 上午9:49:37  
   * @Title: addBatchAdsScreen   
   * @Description: TODO(添加广告和商家屏幕的映射关系)   
   * @param adsScreenList      
   * @return: void       
   *
   */
  void addBatchAdsScreen(List<AdsScreen> adsScreenList);
}
