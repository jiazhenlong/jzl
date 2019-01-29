package com.shop.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  AdsScreen.java   
* @Package com.shop.model   
* @Description:    TODO(广告和商家屏幕的映射关系)   
* @author: jiazhenlong     
* @date:   2018年6月25日 下午5:32:30   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AdsScreen {

  /**
   * 
   */
  private long id;
  
  /**
   * 流量主屏幕ID
   */
  private long shopScreenId;
  
  /**
   * 广告投放ID
   */
  private long shopAdsId;
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getShopScreenId() {
    return shopScreenId;
  }

  public void setShopScreenId(long shopScreenId) {
    this.shopScreenId = shopScreenId;
  }

  public long getShopAdsId() {
    return shopAdsId;
  }

  public void setShopAdsId(long shopAdsId) {
    this.shopAdsId = shopAdsId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
