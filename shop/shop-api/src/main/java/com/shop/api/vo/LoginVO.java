package com.shop.api.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**  
*
* @Title:  LoginVO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(登录响应对象)   
* @author: jiazhenlong     
* @date:   2018年6月28日 下午5:06:28   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class LoginVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 5300007404638174937L;

  private String mobile;
  
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
