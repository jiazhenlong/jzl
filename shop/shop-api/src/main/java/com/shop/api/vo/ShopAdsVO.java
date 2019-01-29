package com.shop.api.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  ShopAdsVO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(广告投放展示对象)   
* @author: jiazhenlong     
* @date:   2018年6月8日 下午4:09:16   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ShopAdsVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 5313681044077483854L;

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
   * 广告ID
   */
  private Long adsId;
  
  /**
   * 审核状态 -1:审核未通过 0:未审核 1:已审核
   */
  private Integer verify;
  
  private String verifyName;
  
  /**
   * 投放状态 0:投放未开始 1:正常投放 2:投放结束
   */
  private Integer status;
  
  private String statusName;
  
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
  private String startDateStr;
  
  /**
   * 投放结束时间
   */
  private String endDateStr;
  
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

  public String getStartDateStr() {
    return startDateStr;
  }

  public void setStartDateStr(String startDateStr) {
    this.startDateStr = startDateStr;
  }

  public String getEndDateStr() {
    return endDateStr;
  }

  public void setEndDateStr(String endDateStr) {
    this.endDateStr = endDateStr;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getVerifyName() {
    return verifyName;
  }

  public void setVerifyName(String verifyName) {
    this.verifyName = verifyName;
  }

  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
