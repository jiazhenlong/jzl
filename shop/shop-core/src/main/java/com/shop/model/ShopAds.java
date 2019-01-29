package com.shop.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  ShopAds.java   
* @Package com.shop.model   
* @Description:    TODO(广告投放)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:41:19   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ShopAds {

  /**
   * 
   */
  private long id;
  
  /**
   * 投放名称
   */
  private String title;
  
  /**
   * 流量主门店ID
   */
  private Long shopId;
  
  /**
   * 商家名称
   */
  private String shopName;
  
  /**
   * 广告ID
   */
  private Long adsId;
  
  /**
   * 审核状态 -1:审核未通过 0:未审核 1:已审核
   */
  private Integer verify;
  
  /**
   * 投放状态 0:投放未开始 1:正常投放 2:投放结束
   */
  private Integer status;
  
  /**
   * 每天投时间开始时间
   */
  private String startTime;
  
  /**
   * 每天投放结束时间
   */
  private String endTime;
  
  /**
   * 投放开始时间
   */
  private Date startDate;
  
  /**
   * 投放结束时间
   */
  private Date endDate;
  
  /**
   * 投放动作 0:广告主主动投 1:流量主主动接
   */
  private Integer action;
  
  /**
   * 拒绝原因：0-不符国家要求, 1-不喜欢, 2-佣金未达要求
   */
  private String reason;
  
  /**
   * 备注内容
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

  public Long getShopId() {
    return shopId;
  }

  public void setShopId(Long shopId) {
    this.shopId = shopId;
  }

  public Long getAdsId() {
    return adsId;
  }

  public void setAdsId(Long adsId) {
    this.adsId = adsId;
  }

  public Integer getVerify() {
    return verify;
  }

  public void setVerify(Integer verify) {
    this.verify = verify;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
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

  public Integer getAction() {
    return action;
  }

  public void setAction(Integer action) {
    this.action = action;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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
