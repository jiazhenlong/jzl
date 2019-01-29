package com.shop.exception;


/**  
*
* @Title:  ApiException.java   
* @Package com.shop.exception   
* @Description:    TODO(接口异常)   
* @author: jiazhenlong     
* @date:   2018年5月25日 下午4:11:30   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ApiException extends BaseException {

  
  /**
   * 
   */
  private static final long serialVersionUID = 4659085678792632457L;

  public ApiException(Error error) {
    super(error);
  }

  public ApiException(Error error, Object[] args) {
    super(error, args);
  }

  public ApiException(Error error, Object[] args, Throwable t) {
    super(error, args, t);
  }

  public ApiException(Throwable cause) {
    super(cause);
  }

  public ApiException(Error error, Throwable cause) {
    super(error, cause);
  }
}
