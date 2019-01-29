package com.shop.api.vo;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  AdsVO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(广告展示对象)   
* @author: jiazhenlong     
* @date:   2018年6月8日 下午4:09:16   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AdsVO {

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
  private int cosType;
  
  /**
   * 出价方式 0:cps
   */
  private String cosTypeName;
  
  /**
   * 跳转地址
   */
  private String url;
  
  /**
   * 佣金比例
   */
  private double commissionRate;
  
  /**
   * -1:审核未通过 0:未审核 1:审核通过
   */
  private int verify;
  
  /**
   * -1:审核未通过 0:未审核 1:审核通过
   */
  private String verifyName;
  
  /**
   * 广告类型: 0-自有商品; 1-他人商品
   */
  private Integer adsType;
  
  /**
   * 广告类型: 0-自有商品; 1-他人商品
   */
  private String adsTypeName;
  
  /**
   * 备注信息
   */
  private String comment;
  
  /**
   * 广告所属广告主
   */
  private long shopId;

  /**
   * 广告图片地址
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


  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public int getCosType() {
    return cosType;
  }


  public void setCosType(int cosType) {
    this.cosType = cosType;
  }


  public String getCosTypeName() {
    return cosTypeName;
  }


  public void setCosTypeName(String cosTypeName) {
    this.cosTypeName = cosTypeName;
  }


  public String getUrl() {
    return url;
  }


  public void setUrl(String url) {
    this.url = url;
  }


  public double getCommissionRate() {
    return commissionRate;
  }


  public void setCommissionRate(double commissionRate) {
    this.commissionRate = commissionRate;
  }


  public int getVerify() {
    return verify;
  }


  public void setVerify(int verify) {
    this.verify = verify;
  }


  public String getVerifyName() {
    return verifyName;
  }


  public void setVerifyName(String verifyName) {
    this.verifyName = verifyName;
  }


  public Integer getAdsType() {
    return adsType;
  }


  public void setAdsType(Integer adsType) {
    this.adsType = adsType;
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


  public String getAdsTypeName() {
    return adsTypeName;
  }


  public void setAdsTypeName(String adsTypeName) {
    this.adsTypeName = adsTypeName;
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
