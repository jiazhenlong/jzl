package com.shop.api.base;

import java.util.List;

/**  
*
* @Title:  MultiPage.java   
* @Package com.shop.api.base   
* @Description:    TODO(分页接口返回值对象)   
* @author: jiazhenlong     
* @date:   2018年6月21日 下午3:47:01   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class MultiPage<T> {

  private Boolean more = Boolean.FALSE;
  
  private List<T> data;

  public MultiPage() {
  }

  public MultiPage(Boolean more, List<T> data) {
      this.more = more;
      this.data = data;
  }

  public Boolean getMore() {
      return more;
  }

  public void setMore(Boolean more) {
      this.more = more;
  }

  public List<T> getData() {
      return data;
  }

  public void setData(List<T> data) {
      this.data = data;
  }
  
}
