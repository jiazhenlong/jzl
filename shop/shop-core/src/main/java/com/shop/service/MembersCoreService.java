package com.shop.service;

import java.util.Optional;

import com.shop.model.Members;

/**  
*
* @Title:  MembersCoreService.java   
* @Package com.shop.service   
* @Description:    TODO(会员)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:10:52   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface MembersCoreService {

  /**
   * 
   * @date:   2018年7月24日 上午11:07:06  
   * @Title: getMembersById   
   * @Description: TODO(根据主键查询会员信息)   
   * @param id
   * @return      
   * @return: Optional<Members>       
   *
   */
  Optional<Members> getMembersById(long id);
}
