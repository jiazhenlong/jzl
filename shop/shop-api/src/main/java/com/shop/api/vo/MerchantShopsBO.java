package com.shop.api.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

/**  
*
* @Title:  MerchantShopsBO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(商家门店业务对象)   
* @author: jiazhenlong     
* @date:   2018年6月8日 下午4:17:16   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class MerchantShopsBO {

  /**
   * 
   */
  private long id;
  
  /**
   * 门店名称
   */
  private String name;
  
  /**
   * 商家主键
   */
  private long merchantId;
  
  /**
   * 商家手机号
   */
  @Pattern(regexp = "[^'\"<>=&]{1,}", message = "门店参数非法，参数不能包含以下非法字符 ' \" < > = &")
  @NotNull(message = "手机号不能为空")
  @Length(min = 11, max = 11, message = "手机号长度非法")
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
   * 是否激活
   */
  private int isActive;
  
  /**
   * 营业执照图片地址
   */
  private String license;
  
  /**
   * 备注
   */
  private String comment;
  
  /**
   * 联系地址
   */
  private String address;
  
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
