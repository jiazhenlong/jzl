package com.shop.model;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  MerchantsAccountLog.java   
* @Package com.shop.model   
* @Description:    TODO(帐户日志)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:38:20   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class MerchantsAccountLog {

  /**
   * 
   */
  private long id;
  
  /**
   * 商家主键
   */
  private long merchantsId;
  
  /**
   * 帐户类型 0:广告主帐户 1:流量主帐户
   */
  private int type;
  
  /**
   * 帐户变动操作符: +, -
   */
  private String op;
  
  
  /**
   * 变动金额
   */
  private BigDecimal amount;
  
  
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


  public int getType() {
    return type;
  }


  public void setType(int type) {
    this.type = type;
  }


  public String getOp() {
    return op;
  }


  public void setOp(String op) {
    this.op = op;
  }


  public BigDecimal getAmount() {
    return amount;
  }


  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }


  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
