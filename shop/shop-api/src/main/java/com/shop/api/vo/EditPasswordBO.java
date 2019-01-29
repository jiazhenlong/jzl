package com.shop.api.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

/**  
*
* @Title:  EditPasswordBO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(修改密码)   
* @author: jiazhenlong     
* @date:   2018年6月29日 上午11:25:17   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class EditPasswordBO {

  /**
   * 商家手机号
   */
  @Pattern(regexp = "[^'\"<>=&]{1,}", message = "参数非法，参数不能包含以下非法字符 ' \" < > = &")
  @NotNull(message = "手机号不能为空")
  @Length(min = 11, max = 11, message = "手机号长度非法")
  private String mobile;
  
  /**
   * 旧密码
   */
  @NotNull(message = "原密码")
  @Length(min = 6, max = 20, message = "原密码长度非法")
  private String passwordOld;
  
  /**
   * 新密码
   */
  @NotNull(message = "新密码")
  @Length(min = 6, max = 20, message = "新密码长度非法")
  private String passwordNew;
  
  /**
   * 确认密码
   */
  @NotNull(message = "确认密码")
  @Length(min = 6, max = 20, message = "确认密码长度非法")
  private String passwordSure;
  
  public String getPasswordOld() {
    return passwordOld;
  }

  public void setPasswordOld(String passwordOld) {
    this.passwordOld = passwordOld;
  }

  public String getPasswordNew() {
    return passwordNew;
  }

  public void setPasswordNew(String passwordNew) {
    this.passwordNew = passwordNew;
  }

  public String getPasswordSure() {
    return passwordSure;
  }

  public void setPasswordSure(String passwordSure) {
    this.passwordSure = passwordSure;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
