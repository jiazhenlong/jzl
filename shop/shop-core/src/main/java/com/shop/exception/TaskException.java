package com.shop.exception;


/**  
*
* @Title:  TaskException.java   
* @Package com.shop.exception   
* @Description:    TODO(定时作业异常)   
* @author: jiazhenlong     
* @date:   2018年5月25日 下午4:07:27   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class TaskException extends BaseException {

  /**
   * 
   */
  private static final long serialVersionUID = 1916638566496848174L;


  public TaskException(Error error) {
    super(error);
  }

  public TaskException(Error error, Object[] args) {
    super(error, args);
  }

  public TaskException(Error error, Object[] args, Throwable t) {
    super(error, args, t);
  }

  public TaskException(Throwable cause) {
    super(cause);
  }

  public TaskException(Error error, Throwable cause) {
    super(error, cause);
  }
}
