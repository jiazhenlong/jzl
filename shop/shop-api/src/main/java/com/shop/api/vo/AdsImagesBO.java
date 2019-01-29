package com.shop.api.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**  
*
* @Title:  AdsImagesBO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(广告图片业务对象)   
* @author: jiazhenlong     
* @date:   2018年6月8日 下午4:22:08   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AdsImagesBO {

  
  /**
   * 图片地址
   */
  @NotBlank(message = "图片地址不能为空")
  private String imgUrl;
  
  
  /**
   * 图片类型，1: 16比9大图 , 2: 1比1小图
   */
  @NotNull
  private Integer type;


  public String getImgUrl() {
    return imgUrl;
  }


  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  public Integer getType() {
    return type;
  }


  public void setType(Integer type) {
    this.type = type;
  }
  
}
