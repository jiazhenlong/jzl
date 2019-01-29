package com.shop.api.base.permission;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**  
*
* @Title:  AuthInterceptor.java   
* @Package com.shop.api.base.permission   
* @Description:    TODO(权限校验)   
* @author: jiazhenlong     
* @date:   2018年7月5日 上午10:41:43   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AuthInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler)
          throws Exception {
    
    // 验证权限
    if (this.hasPermission(handler)) {
        return true;
    }
    //  null == request.getHeader("x-requested-with") TODO 暂时用这个来判断是否为ajax请求
    // 如果没有权限 则抛403异常 springboot会处理，跳转到 /error/403 页面
    response.sendError(HttpStatus.FORBIDDEN.value(), "无权限");
    return false;
  }
  
  
  /**
   * 是否有权限
   *
   * @param handler
   * @return
   */
  private boolean hasPermission(Object handler) {
      if (handler instanceof HandlerMethod) {
          HandlerMethod handlerMethod = (HandlerMethod) handler;
          // 获取方法上的注解
          Access access = handlerMethod.getMethod().getAnnotation(Access.class);
          // 如果方法上的注解为空 则获取类的注解
          if (access == null) {
            access = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Access.class);
          }
          // 如果标记了注解，则判断权限
//          if (access != null && StringUtils.isNotBlank(access.value())) {
//              // redis或数据库 中获取该用户的权限信息 并判断是否有权限
//              Set<String> permissionSet = null;
//              if (CollectionUtils.isEmpty(permissionSet) ){
//                  return false;
//              }
//              return permissionSet.contains(access.value());
//          }
      }
      return true;
  }

  @Override
  public void postHandle(HttpServletRequest request,
                         HttpServletResponse response,
                         Object handler,
                         ModelAndView modelAndView)
          throws Exception {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void afterCompletion(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler,
                              Exception ex)
          throws Exception {
    // TODO Auto-generated method stub
    
  }

}
