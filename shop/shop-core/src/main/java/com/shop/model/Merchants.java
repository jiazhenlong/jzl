package com.shop.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  Merchants.java   
* @Package com.shop.model   
* @Description:    TODO(商家)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:36:28   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class Merchants {

  /**
   * 
   */
  private long id;
  
  /**
   * 商家名称
   */
  private String name;
  
  /**
   * 商家手机号
   */
  private String mobile;
  
  /**
   * 商家邮箱
   */
  private String email;
  
  /**
   * 联系人
   */
  private String contact;
  
  /**
   * 营业执照
   */
  private String license;
  
  /**
   * 审核状态 -1:审核未通过 0:未审核 1:已审核
   */
  private int verify;
  
  /**
   * 商家类型 0:两者 1:广告主 2:流量主
   */
  private int type;
  
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public int getVerify() {
    return verify;
  }

  public void setVerify(int verify) {
    this.verify = verify;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
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
