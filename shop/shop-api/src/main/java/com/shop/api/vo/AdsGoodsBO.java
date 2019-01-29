package com.shop.api.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**  
*
* @Title:  AdsGoodsBO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(广告商品业务对象)   
* @author: jiazhenlong     
* @date:   2018年6月12日 下午5:57:57   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AdsGoodsBO {

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
  @Pattern(regexp = "[^'\"<>=&]{1,}", message = "商品参数非法，参数不能包含以下非法字符 ' \" < > = &")
  @NotNull(message = "商品名称不能为空")
  @Length(min = 1, max = 30, message = "商品名称过长")
  private String goodsName;
  
  /**
   * 商品原价
   */
  @NotNull(message = "商品原价不能为空")
  @DecimalMin(value="0")
  private BigDecimal originalPrice;
  
  /**
   * 商品价格
   */
  @NotNull(message = "商品价格不能为空")
  @DecimalMin(value="0")
  private BigDecimal goodsPrice;
  
  /**
   * 配送方式 0:自取 1:快递
   */
  private Integer deliveryType;
  
  /**
   * 商品描述
   */
  @Pattern(regexp = "[^'\"<>=&]{1,}", message = "商品参数非法，参数不能包含以下非法字符 ' \" < > = &")
  @NotNull(message = "商品描述不能为空")
  @Length(min = 1, max = 200, message = "商品名称过长")
  private String description;
  
  /**
   * 商品使用地址
   */
  private String address;
  
  /**
   * 商品使用起始时间
   */
  @DateTimeFormat(pattern="yyyy-MM-dd ")
  private Date startTime;
  
  /**
   * 商品使用结束时间
   */
  @Future(message = "结束日期必须是一个将来的时间")
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date endTime;
  
  /**
   * 商品库存
   */
  @DecimalMin(value="0", message = "商品库存必须大于等于0")
  private int goodsNumber;
  
  /**
   * 图片主键
   */
  @NotNull(message = "图片主键不能为null")
  private List<Long> imgIdList;
  
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


  public List<Long> getImgIdList() {
    return imgIdList;
  }


  public void setImgIdList(List<Long> imgIdList) {
    this.imgIdList = imgIdList;
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
