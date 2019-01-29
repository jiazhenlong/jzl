package com.shop.dao.mysql;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.Withdraw;

/**  
*
* @Title:  WithdrawDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(提现)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:44:11   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface WithdrawDao {

  /**
   * 
   * @date:   2018年5月28日 下午4:49:06  
   * @Title: addWithdraw   
   * @Description: TODO(新增提现信息)   
   * @param withdraw      
   * @return: void       
   *
   */
  void addWithdraw(@Param("withdraw") Withdraw withdraw);
  
  /**
   * 
   * @date:   2018年5月28日 下午4:49:09  
   * @Title: getWithdrawById   
   * @Description: TODO(根据主键获取提现信息)   
   * @param id
   * @return      
   * @return: Withdraw       
   *
   */
  Withdraw getWithdrawById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年5月28日 下午4:49:13  
   * @Title: delWithdrawById   
   * @Description: TODO(根据主键删除提现信息)   
   * @param id      
   * @return: void       
   *
   */
  void delWithdrawById(@Param("id") long id);
  
  
}
