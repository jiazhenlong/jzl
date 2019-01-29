package com.shop.api.base.permission;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Access {

  /**
   * 
   * @date:   2018年7月5日 上午9:55:50  
   * @Title: value   
   * @Description: TODO(原子权限)   
   * @return      
   * @return: String       
   *
   */
  String value();
}
