package com.shop.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  Ads.java   
* @Package com.shop.model   
* @Description:    TODO(商家广告)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:33:19   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class Ads {

  /**
   * 
   */
  private long id;
  
  /**
   * 标题
   */
  private String title;
  
  /**
   * 出价方式 0:cps
   */
  private Integer cosType;
  
  /**
   * 跳转地址
   */
  private String url;
  
  /**
   * 佣金比例
   */
  private Double commissionRate;
  
  /**
   * 平台佣金比例
   */
  private Double ourCommissionRate;
  
  /**
   * -1:审核未通过 0:未审核 1:审核通过
   */
  private Integer verify;
  
  /**
   * 广告类型: 0-自有商品; 1-他人商品
   */
  private Integer adsType;
  
  /**
   * 备注信息
   */
  private String comment;
  
  /**
   * 广告所属广告主
   */
  private long shopId;
  
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
  
  /**
   * 排序：0-按创建时间倒序，1-佣金最高，2-佣金比最大
   */
  private int number;
  
  /**
   * 商家名称
   */
  private String shopName;
  

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getCosType() {
    return cosType;
  }

  public void setCosType(Integer cosType) {
    this.cosType = cosType;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Double getCommissionRate() {
    return commissionRate;
  }

  public void setCommissionRate(Double commissionRate) {
    this.commissionRate = commissionRate;
  }

  public Integer getVerify() {
    return verify;
  }

  public void setVerify(Integer verify) {
    this.verify = verify;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public long getShopId() {
    return shopId;
  }

  public void setShopId(long shopId) {
    this.shopId = shopId;
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
  
  public Integer getAdsType() {
    return adsType;
  }

  public void setAdsType(Integer adsType) {
    this.adsType = adsType;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public Double getOurCommissionRate() {
    return ourCommissionRate;
  }

  public void setOurCommissionRate(Double ourCommissionRate) {
    this.ourCommissionRate = ourCommissionRate;
  }

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
