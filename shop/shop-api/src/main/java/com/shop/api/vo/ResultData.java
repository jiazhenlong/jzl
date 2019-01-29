package com.shop.api.vo;

import java.io.Serializable;

import com.shop.exception.Error;

public class ResultData implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = -2301255696207424932L;

  private int errorCode = Error.SUCCESS;
  
  private Object data;
  
  private String errorMessage = "";
  
  private String redirect = "";
  
  
  public ResultData() {}
  
  
  public ResultData(Object data) {
    this.data = data;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }


  public String getRedirect() {
    return redirect;
  }


  public void setRedirect(String redirect) {
    this.redirect = redirect;
  }
  
}
