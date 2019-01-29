package com.shop.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  AdsImages.java   
* @Package com.shop.model   
* @Description:    TODO(广告图片)   
* @author: jiazhenlong     
* @date:   2018年6月12日 上午10:44:07   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AdsImages {

  /**
   * 
   */
  private Long id;
  
  /**
   * 所属广告ID
   */
  private Long adsId;
  
  /**
   * 广告图片
   */
  private String imgUrl;
  
  /**
   * 图片类型 1:16比9大图 2:1比1小图
   */
  private int type;
  
  
  private Date createdTime;
  
  
  private Date updatedTime;
  
  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Long getAdsId() {
    return adsId;
  }


  public void setAdsId(Long adsId) {
    this.adsId = adsId;
  }


  public String getImgUrl() {
    return imgUrl;
  }


  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
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
