package com.shop.model;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  Report.java   
* @Package com.shop.model   
* @Description:    TODO(商家报表)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:40:27   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class Report {

  
  /**
   * 
   */
  private long id;
  
  /**
   * 广告主键
   */
  private long adsId;
  
  /**
   * 订单数
   */
  private int orders;
  
  /**
   * 订单金额
   */
  private BigDecimal ordersPrice;
  
  
  /**
   * 平台金额
   */
  private BigDecimal ourCommission;
  
  /**
   * 流量主佣金
   */
  private BigDecimal flowCommission;
  
  /**
   * 日期
   */
  private Date reportDate;
  
  
  public long getId() {
    return id;
  }


  public void setId(long id) {
    this.id = id;
  }


  public long getAdsId() {
    return adsId;
  }


  public void setAdsId(long adsId) {
    this.adsId = adsId;
  }


  public int getOrders() {
    return orders;
  }


  public void setOrders(int orders) {
    this.orders = orders;
  }


  public BigDecimal getOrdersPrice() {
    return ordersPrice;
  }


  public void setOrdersPrice(BigDecimal ordersPrice) {
    this.ordersPrice = ordersPrice;
  }


  public BigDecimal getOurCommission() {
    return ourCommission;
  }


  public void setOurCommission(BigDecimal ourCommission) {
    this.ourCommission = ourCommission;
  }


  public BigDecimal getFlowCommission() {
    return flowCommission;
  }


  public void setFlowCommission(BigDecimal flowCommission) {
    this.flowCommission = flowCommission;
  }


  public Date getReportDate() {
    return reportDate;
  }


  public void setReportDate(Date reportDate) {
    this.reportDate = reportDate;
  }


  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
