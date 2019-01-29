package com.shop.api.base.exceptionhandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.api.vo.ResultData;
import com.shop.exception.ApiException;
import com.shop.exception.Errors;

/**  
*
* @Title:  ExceptionHandle.java   
* @Package com.shop.api.base.exceptionhandle   
* @Description:    TODO(统一异常处理)   
* @author: jiazhenlong     
* @date:   2018年6月14日 上午11:27:06   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@ControllerAdvice
public class ExceptionHandle {
  private final static Logger LOG = LoggerFactory.getLogger(ExceptionHandle.class);



  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResultData Handle(Exception e) {
    LOG.error("异常信息：", e);

    ResultData result = new ResultData();
    if (e instanceof ApiException) {
      ApiException apiException = (ApiException) e;

      result.setErrorCode(apiException.getCode());
      result.setErrorMessage(apiException.getMessage());
    } else if (e instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException manv = (MethodArgumentNotValidException) e;
      
      result.setErrorCode(Errors.ApiErrors.METHOD_ARGUMENT_NOT_VALID.getCode());
      result.setErrorMessage(manv.getBindingResult().getFieldError().getDefaultMessage());
    } else {
      result.setErrorCode(Errors.ApiErrors.SYSTEM_ERROR.getCode());
      result.setErrorMessage(Errors.ApiErrors.SYSTEM_ERROR.getMessage());
    }
    result.setData(false);
    
    return result;
  }
}
