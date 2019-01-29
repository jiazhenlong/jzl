package com.shop.api.base.permission;

/**  
*
* @Title:  PermissionConstants.java   
* @Package com.shop.api.base.permission   
* @Description:    TODO(权限)   
* @author: jiazhenlong     
* @date:   2018年7月5日 上午10:01:13   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface PermissionConstants {

  
  /**********************************公共权限,以PUBLIC开头命名*********************************************/
  
  
  
  /**********************************商家公共权限 ,以 SHOP开头命名*********************************************/
  
  /**
   * 修改资料
   */
  String SHOP_UPDATE_MERCHANT_SHOPS = "updateMerchantShops";
  
  
  /**********************************广告主权限,以ADS开头命名*********************************************/
  
  /**
   * 广告列表
   */
  String ADS_LIST = "ads_list";
  
  /**
   * 广告发布
   */
  String ADS_PUBLISH = "ads_publish";
  
  /**
   * 广告详情
   */
  String ADS_DETAIL = "ads_detail";
  
  /**
   * 广告单个投放
   */
  String ADS_SHOP_CREATE = "ads_shop_create";
  
  /**********************************流量主权限,以FLOW开头命名*********************************************/
}
