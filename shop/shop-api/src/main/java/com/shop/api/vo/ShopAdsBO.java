package com.shop.api.vo;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  AdsBO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(广告业务对象)   
* @author: jiazhenlong     
* @date:   2018年6月8日 下午4:09:03   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ShopAdsBO extends ShopAdsBaseBO {

  
  /**
   * 广告ID
   */
  @NotNull(message = "广告id必填")
  private Long adsId;

  public Long getAdsId() {
    return adsId;
  }

  public void setAdsId(Long adsId) {
    this.adsId = adsId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
