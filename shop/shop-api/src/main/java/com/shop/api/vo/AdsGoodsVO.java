package com.shop.api.vo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  AdsGoodsVO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(广告商品对象展示)   
* @author: jiazhenlong     
* @date:   2018年6月12日 下午5:58:09   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AdsGoodsVO {

  
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
  private String startTimeStr;

  /**
   * 商品使用结束时间
   */
  private String endTimeStr;

  /**
   * 商品库存
   */
  private int goodsNumber;
  
  /**
   * 商品图片地址
   */
  private List<String> imgUrlList;
  
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


  public int getGoodsNumber() {
    return goodsNumber;
  }


  public void setGoodsNumber(int goodsNumber) {
    this.goodsNumber = goodsNumber;
  }


  public List<String> getImgUrlList() {
    return imgUrlList;
  }


  public void setImgUrlList(List<String> imgUrlList) {
    this.imgUrlList = imgUrlList;
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
