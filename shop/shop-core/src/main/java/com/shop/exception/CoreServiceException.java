package com.shop.exception;


/**  
*
* @Title:  CoreServiceException.java   
* @Package com.shop.exception   
* @Description:    TODO(service异常)   
* @author: jiazhenlong     
* @date:   2018年5月25日 下午4:11:30   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class CoreServiceException extends BaseException {

  
  /**
   * 
   */
  private static final long serialVersionUID = 4659085678792632457L;

  public CoreServiceException(Error error) {
    super(error);
  }

  public CoreServiceException(Error error, Object[] args) {
    super(error, args);
  }

  public CoreServiceException(Error error, Object[] args, Throwable t) {
    super(error, args, t);
  }

  public CoreServiceException(Throwable cause) {
    super(cause);
  }

  public CoreServiceException(Error error, Throwable cause) {
    super(error, cause);
  }
}
