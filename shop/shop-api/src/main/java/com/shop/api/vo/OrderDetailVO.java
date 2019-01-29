package com.shop.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  OrderDetailVO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(广告主订单详情)   
* @author: jiazhenlong     
* @date:   2018年7月23日 下午3:44:51   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class OrderDetailVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -927079579696345944L;

  /**
   * 订单号
   */
  private String orderSn;

  /**
   * 订单状态, 0:待消费 1:交易完成 2:交易关闭
   */
  private int status;

  /**
  * 订单状态, 0:待消费 1:交易完成 2:交易关闭
  */
  private String statusName;

  /**
   * 支付状态,0:未支付1:已支付
   */
  private int payStatus;

  /**
   * 商品名称
   */
  private String goodsName;

  /**
   * 商品价格
   */
  private BigDecimal goodsPrice;

  /**
   * 商品数量
   */
  private int goodsNumber;

  /**
   * 图片url
   */
  private String imgUrl;

  /**
   * 实际收入
   */
  private BigDecimal realIncome;

  /**
   * 订单来源
   */
  private String orderSource;

  /**
   * 用户名
   */
  private String username;

  /**
   * 手机号
   */
  private String mobile;

  /**
   * 买家留言
   */
  private String customerMessage;

  /**
   * 平台佣金
   */
  private BigDecimal ourCommission;

  /**
   * 流量主佣金
   */
  private BigDecimal flowCommission;

  /**
   * 商家名称
   */
  private String shopName;

  /**
   * 广告名称
   */
  private String adsName;

  /**
   * 商品使用地址
   */
  private String goodsAddress;

  /**
   * 商品使用起始时间
   */
  private String startTimeStr;

  /**
   * 商品使用结束时间
   */
  private String endTimeStr;

  /**
   * 订单完成时间
   */
  private String completeTimeStr;

  /**
   * 订单创建时间
   */
  private String createdTimeStr;

  /**
  * 广告投放名称
  */
  private String shopAdsName;

  /**
  * 广告佣金比例
  */
  private double adsCommissionRate;


  public String getOrderSn() {
    return orderSn;
  }

  public void setOrderSn(String orderSn) {
    this.orderSn = orderSn;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }

  public int getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(int payStatus) {
    this.payStatus = payStatus;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public BigDecimal getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(BigDecimal goodsPrice) {
    this.goodsPrice = goodsPrice;
  }

  public int getGoodsNumber() {
    return goodsNumber;
  }

  public void setGoodsNumber(int goodsNumber) {
    this.goodsNumber = goodsNumber;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public BigDecimal getRealIncome() {
    return realIncome;
  }

  public void setRealIncome(BigDecimal realIncome) {
    this.realIncome = realIncome;
  }

  public String getOrderSource() {
    return orderSource;
  }

  public void setOrderSource(String orderSource) {
    this.orderSource = orderSource;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getCustomerMessage() {
    return customerMessage;
  }

  public void setCustomerMessage(String customerMessage) {
    this.customerMessage = customerMessage;
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

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public String getGoodsAddress() {
    return goodsAddress;
  }

  public void setGoodsAddress(String goodsAddress) {
    this.goodsAddress = goodsAddress;
  }

  public String getStartTimeStr() {
    return startTimeStr;
  }

  public void setStartTimeStr(String startTimeStr) {
    this.startTimeStr = startTimeStr;
  }

  public String getEndTimeStr() {
    return endTimeStr;
  }

  public void setEndTimeStr(String endTimeStr) {
    this.endTimeStr = endTimeStr;
  }

  public String getAdsName() {
    return adsName;
  }

  public void setAdsName(String adsName) {
    this.adsName = adsName;
  }

  public String getCompleteTimeStr() {
    return completeTimeStr;
  }

  public void setCompleteTimeStr(String completeTimeStr) {
    this.completeTimeStr = completeTimeStr;
  }

  public String getCreatedTimeStr() {
    return createdTimeStr;
  }

  public void setCreatedTimeStr(String createdTimeStr) {
    this.createdTimeStr = createdTimeStr;
  }

  public String getShopAdsName() {
    return shopAdsName;
  }

  public void setShopAdsName(String shopAdsName) {
    this.shopAdsName = shopAdsName;
  }

  public double getAdsCommissionRate() {
    return adsCommissionRate;
  }

  public void setAdsCommissionRate(double adsCommissionRate) {
    this.adsCommissionRate = adsCommissionRate;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
