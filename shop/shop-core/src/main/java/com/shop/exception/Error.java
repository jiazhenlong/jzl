package com.shop.exception;


/**  
*
* @Title:  Error.java   
* @Package com.shop.exception   
* @Description:    TODO(异常信息接口)   
* @author: jiazhenlong     
* @date:   2018年5月25日 下午3:53:08   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface Error {

  /** success code 使用200范围 **/
  int SUCCESS = 200;

  /** DB访问错误 **/
  int DB = 91000;
  /** I/O文件类访问错误 **/
  int DS = 92000;
  /** 缓存类访问错误 **/
  int CACHE = 93000;
  /** 特定第三方Local api调用错误，如文件指文计算，文件压缩，IP转城市等 **/
  int THIRD = 94000;
  /** 访问其它应用出错，如其它服务化接口 **/
  int BS = 95000;
  /** 安全类出错，试图操作未授权资源 **/
  int SECURITY = 98000;

  // 服务端
  /** web代码层出错 **/
  int WEB = 10000;
  /** service代码层出错 **/
  int BIZ = 20000;
  /** dao代码层出错 **/
  int DAO = 30000;

  public int getCode();

  public String getMessage();
}
