package com.shop.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  MerchantShops.java   
* @Package com.shop.model   
* @Description:    TODO(商家门店)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:34:54   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class MerchantShops {

  /**
   * 
   */
  private long id;
  
  /**
   * 门店名称
   */
  private String name;
  
  /**
   * 商家密码
   */
  private String password;
  
  /**
   * 商家主键
   */
  private long merchantId;
  
  /**
   * 商家手机号
   */
  private String mobile;
  
  /**
   * 联系人
   */
  private String contact;
  
  /**
   * 审核状态 -1:审核未通过 0:未审核 1:已审核
   */
  private int verify;
  
  /**
   * 营业执照图片地址
   */
  private String license;
  
  /**
   * 是否激活
   */
  private int isActive;
  
  /**
   * 备注
   */
  private String comment;
  
  /**
   * 联系地址
   */
  private String address;
  
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


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public long getMerchantId() {
    return merchantId;
  }


  public void setMerchantId(long merchantId) {
    this.merchantId = merchantId;
  }


  public String getMobile() {
    return mobile;
  }


  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getContact() {
    return contact;
  }


  public void setContact(String contact) {
    this.contact = contact;
  }


  public int getVerify() {
    return verify;
  }


  public void setVerify(int verify) {
    this.verify = verify;
  }


  public int getIsActive() {
    return isActive;
  }


  public void setIsActive(int isActive) {
    this.isActive = isActive;
  }


  public String getComment() {
    return comment;
  }


  public void setComment(String comment) {
    this.comment = comment;
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


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public String getLicense() {
    return license;
  }


  public void setLicense(String license) {
    this.license = license;
  }


  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
