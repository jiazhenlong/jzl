package com.shop.dao.mysql;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.MerchantShops;

/**  
*
* @Title:  MerchantShopsDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(商家门店)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:07:33   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface MerchantShopsDao {

  
  /**
   * 
   * @date:   2018年5月28日 下午3:22:06  
   * @Title: addMerchantShops   
   * @Description: TODO(新增商家门店信息)   
   * @param merchantShops      
   * @return: void       
   *
   */
  void addMerchantShops(@Param("merchantShops") MerchantShops merchantShops);
  
  /**
   * 
   * @date:   2018年5月28日 下午3:22:10  
   * @Title: getMerchantShopsById   
   * @Description: TODO(根据主键获取商家门店信息)   
   * @param id
   * @return      
   * @return: MerchantShops       
   *
   */
  MerchantShops getMerchantShopsById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年5月28日 下午3:22:14  
   * @Title: delMerchantShopsById   
   * @Description: TODO(根据主键删除商家门店信息)   
   * @param id      
   * @return: void       
   *
   */
  void delMerchantShopsById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年6月22日 下午5:12:58  
   * @Title: updateMerchantShops   
   * @Description: TODO(修改商家门店)   
   * @param merchantShops      
   * @return: void       
   *
   */
  void updateMerchantShops(@Param("merchantShops") MerchantShops merchantShops);
  
  /**
   * 
   * @date:   2018年6月28日 下午5:01:39  
   * @Title: getPasswordByMobile   
   * @Description: TODO(根据手机号查询密码)   
   * @param mobile
   * @return      
   * @return: String       
   *
   */
  String getPasswordByMobile(@Param("mobile") String mobile);
  
  /**
   * 
   * @date:   2018年6月29日 上午11:38:07  
   * @Title: updatePassword   
   * @Description: TODO(修改密码)   
   * @param mobile
   * @param password
   * @param updatedTime      
   * @return: void       
   *
   */
  void updatePassword(@Param("mobile") String mobile, @Param("password") String password, @Param("updatedTime") Date updatedTime);
}
