package com.shop.model;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  MerchantsAccount.java   
* @Package com.shop.model   
* @Description:    TODO(商家帐户)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:37:24   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class MerchantsAccount {

  /**
   * 
   */
  private long id;
  
  /**
   * 商家主键
   */
  private long merchantsId;
  
  /**
   * 广告主帐户金额
   */
  private BigDecimal adserAmount;
  
  /**
   * 流量主帐户金额
   */
  private BigDecimal flowAmount;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getMerchantsId() {
    return merchantsId;
  }

  public void setMerchantsId(long merchantsId) {
    this.merchantsId = merchantsId;
  }

  public BigDecimal getAdserAmount() {
    return adserAmount;
  }

  public void setAdserAmount(BigDecimal adserAmount) {
    this.adserAmount = adserAmount;
  }

  public BigDecimal getFlowAmount() {
    return flowAmount;
  }

  public void setFlowAmount(BigDecimal flowAmount) {
    this.flowAmount = flowAmount;
  }
  
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
