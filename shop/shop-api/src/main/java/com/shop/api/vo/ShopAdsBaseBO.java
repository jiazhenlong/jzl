package com.shop.api.vo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**  
*
* @Title:  ShopAdsBaseBO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(广告投放)   
* @author: jiazhenlong     
* @date:   2018年7月3日 下午3:26:45   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ShopAdsBaseBO {

  /**
   * 
   */
  private long id;
  
  /**
   * 投放名称
   */
  @Pattern(regexp = "[^'\"<>=&]{1,}", message = "参数非法，参数不能包含以下非法字符 ' \" < > = &")
  @NotNull(message = "投放名称不能为空")
  @Length(min = 1, max = 20, message = "投放名称过长")
  private String title;
  
  /**
   * 门店屏幕映射关系集合
   */
  @NotNull(message = "门店屏幕映射关系集合必填")
  private List<ShopScreenMapperBO> shopScreenMapperBOList;
  
  /**
   * 每天投时间开始时间
   */
  @NotNull(message = "广告每天投放开始时间必填")
  private String startTime;
  
  /**
   * 每天投放结束时间
   */
  @NotNull(message = "广告每天投放结束时间必填")
  private String endTime;
  
  /**
   * 投放开始时间
   */
  @DateTimeFormat(pattern="yyyy-MM-dd")
  @NotNull(message = "广告投放开始日期必填")
  private Date startDate;
  
  /**
   * 投放结束时间
   */
  @DateTimeFormat(pattern="yyyy-MM-dd")
  @Future(message = "广告投放结束日期必须是一个未来的时间")
  @NotNull(message = "广告投放结束日期必填")
  private Date endDate;
  


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<ShopScreenMapperBO> getShopScreenMapperBOList() {
    return shopScreenMapperBOList;
  }

  public void setShopScreenMapperBOList(List<ShopScreenMapperBO> shopScreenMapperBOList) {
    this.shopScreenMapperBOList = shopScreenMapperBOList;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
