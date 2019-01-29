package com.shop.api.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

/**  
*
* @Title:  ShopAdsScreenMapperBO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(商家和屏幕的对象关系)   
* @author: jiazhenlong     
* @date:   2018年7月4日 下午1:56:36   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ShopScreenMapperBO {

  /**
   * 屏幕ID集合
   */
  @NotNull(message = "屏幕id必填")
  private List<Long> screenIdList;
  
  /**
   * 商家
   */
  @NotNull(message = "商家id必填")
  private Long shopId;

  public List<Long> getScreenIdList() {
    return screenIdList;
  }

  public void setScreenIdList(List<Long> screenIdList) {
    this.screenIdList = screenIdList;
  }

  public Long getShopId() {
    return shopId;
  }

  public void setShopId(Long shopId) {
    this.shopId = shopId;
  }
  
}
