package com.shop.api.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

/**  
*
* @Title:  ShopRegisterBO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(商家账号注册)   
* @author: jiazhenlong     
* @date:   2018年6月28日 下午2:42:20   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ShopRegisterBO {

  
  /**
   * 商家手机号
   */
  @Pattern(regexp = "[^'\"<>=&]{1,}", message = "参数非法，参数不能包含以下非法字符 ' \" < > = &")
  @NotNull(message = "手机号不能为空")
  @Length(min = 11, max = 11, message = "手机号长度非法")
  private String mobile;
  
  /**
   * 商家密码
   */
  @NotNull(message = "密码")
  private String password;
  
  /**
   * 验证码
   */
  @NotNull(message = "验证码")
  private Integer validateNo;
  
  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getValidateNo() {
    return validateNo;
  }

  public void setValidateNo(Integer validateNo) {
    this.validateNo = validateNo;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
