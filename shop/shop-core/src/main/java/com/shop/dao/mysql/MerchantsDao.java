package com.shop.dao.mysql;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.Merchants;

/**  
*
* @Title:  MerchantsDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(商家)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:06:54   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface MerchantsDao {

  
  /**
   * 
   * @date:   2018年5月28日 下午3:07:08  
   * @Title: addMerchants   
   * @Description: TODO(新增商家信息)   
   * @param merchants      
   * @return: void       
   *
   */
  void addMerchants(@Param("merchants") Merchants merchants);
  
  /**
   * 
   * @date:   2018年5月28日 下午3:07:14  
   * @Title: getMerchantsById   
   * @Description: TODO(根据主键查询商家信息)   
   * @param id
   * @return      
   * @return: Merchants       
   *
   */
  Merchants getMerchantsById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年5月28日 下午3:08:08  
   * @Title: delMerchantsById   
   * @Description: TODO(根据主键删除商家信息)   
   * @param id      
   * @return: void       
   *
   */
  void delMerchantsById(@Param("id") long id);
  
}
