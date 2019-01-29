package com.shop.exception;

import com.alibaba.fastjson.JSON;

/**  
*
* @Title:  BaseException.java   
* @Package com.shop.exception   
* @Description:    TODO(异常基础类)   
* @author: jiazhenlong     
* @date:   2018年5月25日 下午4:04:05   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class BaseException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 6311349813704807001L;

  
  private int code;

  public BaseException(Error error) {
      super(error.getMessage());
      this.code = error.getCode();
  }

  public BaseException(Error error, Object[] args) {
      super(buildMessage(error.getMessage(), args));
      this.code = error.getCode();
  }

  public BaseException(Error error, Object[] args, Throwable t) {
      super(buildMessage(error.getMessage(), args), t);
      this.code = error.getCode();
  }

  public BaseException(Throwable cause) {
      super(cause);
  }

  public BaseException(Error error, Throwable cause) {
      super(error.getMessage(), cause);
  }

  protected static String buildMessage(String msg, Object[] args) {
      if (null != args) {
          return msg + " args:" + JSON.toJSON(args);
      }
      return msg;
  }

  public int getCode() {
      return code;
  }
}
