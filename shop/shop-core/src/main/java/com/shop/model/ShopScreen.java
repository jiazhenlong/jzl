package com.shop.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  ShopScreen.java   
* @Package com.shop.model   
* @Description:    TODO(商家门店电视屏)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:42:17   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ShopScreen {

  /**
   * 
   */
  private long id;
  
  /**
   * 流量主门店ID
   */
  private long shopId;
  
  /**
   * 屏幕名称
   */
  private String name;
  
  /**
   * 备注
   */
  private String comment;
  
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


  public long getShopId() {
    return shopId;
  }


  public void setShopId(long shopId) {
    this.shopId = shopId;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getComment() {
    return comment;
  }


  public void setComment(String comment) {
    this.comment = comment;
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
