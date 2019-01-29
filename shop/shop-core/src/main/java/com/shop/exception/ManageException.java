package com.shop.exception;


/**  
*
* @Title:  ManageException.java   
* @Package com.shop.exception   
* @Description:    TODO(管理端异常)   
* @author: jiazhenlong     
* @date:   2018年5月25日 下午4:09:33   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ManageException extends BaseException {

  
  /**
   * 
   */
  private static final long serialVersionUID = -5588934955582823904L;

  public ManageException(Error error) {
    super(error);
  }

  public ManageException(Error error, Object[] args) {
    super(error, args);
  }

  public ManageException(Error error, Object[] args, Throwable t) {
    super(error, args, t);
  }

  public ManageException(Throwable cause) {
    super(cause);
  }

  public ManageException(Error error, Throwable cause) {
    super(error, cause);
  }
}
