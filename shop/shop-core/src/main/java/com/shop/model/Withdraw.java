package com.shop.model;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  Withdraw.java   
* @Package com.shop.model   
* @Description:    TODO(提现)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:43:15   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class Withdraw {

  /**
   * 
   */
  private long id;
  
  /**
   * 商家ID
   */
  private long merchantsId;
  
  /**
   * 提现金额
   */
  private BigDecimal price;
  
  /**
   * 提现手续费
   */
  private BigDecimal feePrice;
  
  /**
   * 提现状态 0:待审核 1:审核通过提现中 2:提现成功 -1:提现失败
   */
  private int status;
  
  /**
   * 提现帐号
   */
  private String withdrawNumber;
  
  /**
   * 备注
   */
  private String comment;
  
  /**
   * 支付时间
   */
  private Date payTime;
  
  /**
   * 创建时间
   */
  private Date createdTime;
  
  /**
   * 修改时间
   */
  private Date updatedTime;
  
  
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


  public BigDecimal getPrice() {
    return price;
  }


  public void setPrice(BigDecimal price) {
    this.price = price;
  }


  public BigDecimal getFeePrice() {
    return feePrice;
  }


  public void setFeePrice(BigDecimal feePrice) {
    this.feePrice = feePrice;
  }


  public int getStatus() {
    return status;
  }


  public void setStatus(int status) {
    this.status = status;
  }


  public String getWithdrawNumber() {
    return withdrawNumber;
  }


  public void setWithdrawNumber(String withdrawNumber) {
    this.withdrawNumber = withdrawNumber;
  }


  public String getComment() {
    return comment;
  }


  public void setComment(String comment) {
    this.comment = comment;
  }


  public Date getPayTime() {
    return payTime;
  }


  public void setPayTime(Date payTime) {
    this.payTime = payTime;
  }


  public Date getCreatedTime() {
    return createdTime;
  }


  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }


  public Date getUpdatedTime() {
    return updatedTime;
  }


  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }


  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
