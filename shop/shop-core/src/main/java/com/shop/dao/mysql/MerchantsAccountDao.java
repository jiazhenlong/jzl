package com.shop.dao.mysql;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.MerchantsAccount;

/**  
*
* @Title:  MerchantsAccountDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(商家帐户)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:06:19   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface MerchantsAccountDao {

  
  /**
   * 
   * @date:   2018年5月28日 下午2:40:04  
   * @Title: addMerchantsAccount   
   * @Description: TODO(新增商家帐户信息)   
   * @param merchantsAccount      
   * @return: void       
   *
   */
  void addMerchantsAccount(@Param("merchantsAccount") MerchantsAccount merchantsAccount);
  
  /**
   * 
   * @date:   2018年5月28日 下午2:40:08  
   * @Title: getMerchantsAccountById   
   * @Description: TODO(根据主键获取商家帐户信息)   
   * @param id
   * @return      
   * @return: MerchantsAccount       
   *
   */
  MerchantsAccount getMerchantsAccountById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年5月28日 下午2:40:12  
   * @Title: delMerchantsAccountById   
   * @Description: TODO(根据主键删除商家帐户信息)   
   * @param id      
   * @return: void       
   *
   */
  void delMerchantsAccountById(@Param("id") long id);
}
