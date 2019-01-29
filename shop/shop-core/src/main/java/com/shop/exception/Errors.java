package com.shop.exception;


/**  
*
* @Title:  Errors.java   
* @Package com.shop.exception   
* @Description:    TODO(异常信息定义)   
* @author: jiazhenlong     
* @date:   2018年5月25日 下午3:54:11   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class Errors {

  /**
   * errors defined for core service module
   * code start from 0 end with 99
   */
  public enum CoreServiceErrors implements Error {
    SYSTEM_ERROR(1001, "未知系统错误!"), 
    DATA_NOT_EXIST(1002, "数据不存在!"),
    NOT_FOUND(1003,"东西没找到");

    private int code;
    private String message;

    CoreServiceErrors(int code, String message) {
      this.code = code;
      this.message = message;
    }

    @Override
    public int getCode() {
      return code;
    }

    @Override
    public String getMessage() {
      return message;
    }
  }



  /**
   * error codes defined for task module
   * code start from 300 end with 399
   */
  public enum TaskErrors implements Error {
    SYSTEM_ERROR(900201, "未知系统错误!"), 
    DATA_NOT_EXIST(900202, "数据不存在!");

    private int code;
    private String message;

    TaskErrors(int code, String message) {
      this.code = code;
      this.message = message;
    }

    @Override
    public int getCode() {
      return code;
    }

    @Override
    public String getMessage() {
      return message;
    }
  }


  /**
   * error codes defined for web api
   * code start from 400 end with 499
   */
  public enum ApiErrors implements Error {
    SYSTEM_ERROR(900400, "未知系统错误!"), 
    METHOD_ARGUMENT_NOT_VALID(900401, "方法参数验证异常!"), 
    WRONG_IMAGE_SUFFIX(900402, "错误的文件后缀"), 
    RATE_ERROR(900403, "图片比例不对"), 
    DATA_NOT_EXIST(900404, "数据不存在!"),
    ADS_IMGID_NOT_EXIST(900405, "广告图片id数据不存在!"),
    GOODS_IMGID_NOT_EXIST(900406, "商品图片id数据不存在!"),
    UPDATE_DATA_IS_ERROR(900407, "修改的数据有误，请检查!"),
    VERSION_IS_LOW(900408, "数据版本过低!"),
    VALIDATE_IS_ERROR(900409, "验证码错误!"),
    LOGIN_NAME_IS_ERROR(900410, "登录账号不存在!"),
    LOGIN_PASSWORD_IS_ERROR(900411, "密码错误!"),
    PASSWORD_NOT_AGREE(900412, "两次输入密码不一致!"),
    WAITING_PAYMENT(900413, "订单未付款!"),
    TRADING_END(900414, "订单已核销!"),
    TRADING_CLOSED(900415, "订单已关闭!")
    ;

    private int code;
    private String message;

    ApiErrors(int code, String message) {
      this.code = code;
      this.message = message;
    }
    
    @Override
    public int getCode() {
      return code;
    }

    @Override
    public String getMessage() {
      return message;
    }
  }

  public enum ManagerErrors implements Error {

    SYSTEM_ERROR(900601, "未知系统错误!"), 

    
    DATA_NOT_EXIST(900602, "数据不存在!");

    private int code;
    private String message;

    ManagerErrors(int code, String message) {
      this.code = code;
      this.message = message;
    }

    @Override
    public int getCode() {
      return code;
    }

    @Override
    public String getMessage() {
      return message;
    }
  }
}
