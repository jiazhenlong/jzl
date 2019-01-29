package com.shop.api.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  ShopAdsBatchBO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(批量投放广告)   
* @author: jiazhenlong     
* @date:   2018年7月3日 下午3:34:38   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ShopAdsBatchBO extends ShopAdsBaseBO {

  /**
   * 广告ID集合
   */
  @NotNull(message = "广告id必填")
  private List<Long> adsIdList;

  public List<Long> getAdsIdList() {
    return adsIdList;
  }

  public void setAdsIdList(List<Long> adsIdList) {
    this.adsIdList = adsIdList;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
