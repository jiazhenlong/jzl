package com.shop.api.vo;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  OrdersVO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(订单展示对象)   
* @author: jiazhenlong     
* @date:   2018年6月8日 下午4:14:10   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class OrdersVO {
  /**
   * 订单id
   */
  private long id;

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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

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

  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
