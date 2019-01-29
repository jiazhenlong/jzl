package com.shop.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  Members.java   
* @Package com.shop.model   
* @Description:    TODO(会员-买家)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:34:04   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class Members {

  /**
   * 
   */
  private long id;
  
  /**
   * 用户名
   */
  private String username;
  
  /**
   * 手机号
   */
  private String mobile;
  
  /**
   * 用户邮箱
   */
  private String email;
  
  /**
   * 用户微信唯一标识符
   */
  private String openId;
  
  /**
   * 用户头像
   */
  private String avatarUrl;
  
  /**
   * 用户性别 0:未知 1:男性 2:女性
   */
  private int gender;
  
  /**
   * 用户所在地区
   */
  private String address;
  
  /**
   * 留言
   */
  private String remark;
  
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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
  
  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
