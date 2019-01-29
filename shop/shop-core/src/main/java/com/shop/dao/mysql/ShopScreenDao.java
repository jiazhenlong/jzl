package com.shop.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.AdsScreen;
import com.shop.model.ShopScreen;

/**  
*
* @Title:  ShopScreenDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(商家门店电视屏)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:46:18   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface ShopScreenDao {

  /**
   * 
   * @date:   2018年5月28日 下午4:37:37  
   * @Title: addShopScreen   
   * @Description: TODO(新增商家门店电视屏)   
   * @param shopScreen      
   * @return: void       
   *
   */
  void addShopScreen(@Param("shopScreen") ShopScreen shopScreen);
  
  /**
   * 
   * @date:   2018年5月28日 下午4:37:53  
   * @Title: getShopScreenById   
   * @Description: TODO(根据主键获取商家门店电视屏)   
   * @param id
   * @return      
   * @return: ShopScreen       
   *
   */
  ShopScreen getShopScreenById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年5月28日 下午4:37:56  
   * @Title: delShopScreenById   
   * @Description: TODO(根据主键删除商家门店电视屏)   
   * @param id      
   * @return: void       
   *
   */
  void delShopScreenById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年6月25日 下午5:47:19  
   * @Title: addBatchAdsScreen   
   * @Description: TODO(添加广告和商家屏幕的映射关系)   
   * @param adsScreenList      
   * @return: void       
   *
   */
  void addBatchAdsScreen(@Param("adsScreenList") List<AdsScreen> adsScreenList);
}
