package com.shop.model;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  AdsGoods.java   
* @Package com.shop.model   
* @Description:    TODO(广告商品)   
* @author: jiazhenlong     
* @date:   2018年6月12日 上午10:33:19   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AdsGoods {

  /**
   * 
   */
  private long id;

  /**
   * 广告主键
   */
  private long adsId;

  /**
   * 商品名称
   */
  private String goodsName;

  /**
   * 商品原价
   */
  private BigDecimal originalPrice;

  /**
   * 商品价格
   */
  private BigDecimal goodsPrice;

  /**
   * 配送方式 0:自取 1:快递
   */
  private Integer deliveryType;

  /**
   * 商品描述
   */
  private String description;

  /**
   * 商品使用地址
   */
  private String address;

  /**
   * 商品使用起始时间
   */
  private Date startTime;

  /**
   * 商品使用结束时间
   */
  private Date endTime;

  /**
   * 商品库存
   */
  private int goodsNumber;

  /**
   * 创建时间
   */
  private Date createdTime;

  /**
   * 修改时间
   */
  private Date updatedTime;
  
  /**
   * 版本号
   */
  private int version;


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


  public String getGoodsName() {
    return goodsName;
  }


  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public BigDecimal getOriginalPrice() {
    return originalPrice;
  }


  public void setOriginalPrice(BigDecimal originalPrice) {
    this.originalPrice = originalPrice;
  }


  public BigDecimal getGoodsPrice() {
    return goodsPrice;
  }


  public void setGoodsPrice(BigDecimal goodsPrice) {
    this.goodsPrice = goodsPrice;
  }


  public Integer getDeliveryType() {
    return deliveryType;
  }


  public void setDeliveryType(Integer deliveryType) {
    this.deliveryType = deliveryType;
  }


  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public String getAddress() {
    return address;
  }


  public void setAddress(String address) {
    this.address = address;
  }


  public Date getStartTime() {
    return startTime;
  }


  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }


  public Date getEndTime() {
    return endTime;
  }


  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }


  public int getGoodsNumber() {
    return goodsNumber;
  }


  public void setGoodsNumber(int goodsNumber) {
    this.goodsNumber = goodsNumber;
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


  public int getVersion() {
    return version;
  }


  public void setVersion(int version) {
    this.version = version;
  }


  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
