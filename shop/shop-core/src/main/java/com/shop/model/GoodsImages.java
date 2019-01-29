package com.shop.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  GoodsImages.java   
* @Package com.shop.model   
* @Description:    TODO(商品图片)   
* @author: jiazhenlong     
* @date:   2018年6月12日 上午10:50:45   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class GoodsImages {

  /**
   * 
   */
  private long id;
  
  /**
   * 商品主键
   */
  private long goodsId;
  
  /**
   * 图片url
   */
  private String imgUrl;
  
  /**
   * 商品图片描述
   */
  private String description;
  
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



  public long getGoodsId() {
    return goodsId;
  }



  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }



  public String getImgUrl() {
    return imgUrl;
  }



  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }



  public String getDescription() {
    return description;
  }



  public void setDescription(String description) {
    this.description = description;
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
