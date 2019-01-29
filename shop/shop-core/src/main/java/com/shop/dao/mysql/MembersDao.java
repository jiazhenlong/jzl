package com.shop.dao.mysql;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.Members;

/**  
*
* @Title:  MembersDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(会员)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:08:25   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface MembersDao {

  
  /**
   * 
   * @date:   2018年5月28日 下午2:20:18  
   * @Title: addMembers   
   * @Description: TODO(新增会员信息)   
   * @param members      
   * @return: void       
   *
   */
  void addMembers(@Param("members") Members members);
  
  /**
   * 
   * @date:   2018年5月28日 下午2:20:21  
   * @Title: getMembersById   
   * @Description: TODO(根据主键查询会员)   
   * @param id
   * @return      
   * @return: Members       
   *
   */
  Members getMembersById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年5月28日 下午2:20:25  
   * @Title: delMembersById   
   * @Description: TODO(根据主键删除会员)   
   * @param id      
   * @return: void       
   *
   */
  void delMembersById(@Param("id") long id);
  
}
