package com.shop.dao.mysql;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.MerchantsAccountLog;

/**  
*
* @Title:  MerchantsAccountLogDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(帐户日志)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:05:24   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface MerchantsAccountLogDao {

  /**
   * 
   * @date:   2018年5月28日 下午2:53:50  
   * @Title: addMerchantsAccountLog   
   * @Description: TODO(新增账户日志)   
   * @param merchantsAccountLog      
   * @return: void       
   *
   */
  void addMerchantsAccountLog(@Param("merchantsAccountLog") MerchantsAccountLog merchantsAccountLog);
  
  /**
   * 
   * @date:   2018年5月28日 下午2:53:47  
   * @Title: getMerchantsAccountLogById   
   * @Description: TODO(根据主键查询账户日志信息)   
   * @param id
   * @return      
   * @return: MerchantsAccountLog       
   *
   */
  MerchantsAccountLog getMerchantsAccountLogById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年5月28日 下午2:53:43  
   * @Title: delMerchantsAccountLogById   
   * @Description: TODO(根据主键删除账户信息)   
   * @param id      
   * @return: void       
   *
   */
  void delMerchantsAccountLogById(@Param("id") long id);
}
