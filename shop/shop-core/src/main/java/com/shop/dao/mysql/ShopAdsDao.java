package com.shop.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.ShopAds;

/**  
*
* @Title:  ShopAdsDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(广告投放)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:45:35   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface ShopAdsDao {

  /**
   * 
   * @date:   2018年5月28日 下午4:28:26  
   * @Title: addShopAds   
   * @Description: TODO(新增广告投放信息)   
   * @param shopAds      
   * @return: void       
   *
   */
  void addShopAds(@Param("shopAds") ShopAds shopAds);

  /**
   * 
   * @date:   2018年6月26日 下午2:44:53  
   * @Title: addBatchShopAds   
   * @Description: TODO(批量创建广告投放)   
   * @param shopAdsList      
   * @return: void       
   *
   */
  void addBatchShopAds(@Param("shopAdsList") List<ShopAds> shopAdsList);

  /**
   * 
   * @date:   2018年5月28日 下午4:28:30  
   * @Title: getShopAdsById   
   * @Description: TODO(根据主键获取广告投放信息)   
   * @param id
   * @return      
   * @return: ShopAds       
   *
   */
  ShopAds getShopAdsById(@Param("id") long id);

  /**
   * 
   * @date:   2018年5月28日 下午4:28:33  
   * @Title: delShopAdsById   
   * @Description: TODO(根据主键删除广告投放信息)   
   * @param id      
   * @return: void       
   *
   */
  void delShopAdsById(@Param("id") long id);

  /**
   * 
   * @date:   2018年7月5日 下午3:29:02  
   * @Title: findShopAdsListPage   
   * @Description: TODO(分页查询投放列表)   
   * @param adsShopId
   * @param verify
   * @param status
   * @param title
   * @param pageIndex
   * @param pageSize
   * @return      
   * @return: List<ShopAds>       
   *
   */
  List<ShopAds> findShopAdsListPage(@Param("adsShopId") Long adsShopId,
                                    @Param("verify") Integer verify,
                                    @Param("status") Integer status,
                                    @Param("title") String title,
                                    @Param("pageIndex") int pageIndex,
                                    @Param("pageSize") int pageSize);

  /**
   * 
   * @date:   2018年7月5日 下午4:03:50  
   * @Title: countShopAdsPage   
   * @Description: TODO(广告投放分页数据统计)   
   * @param adsShopId
   * @param verify
   * @param status
   * @param title
   * @return      
   * @return: int       
   *
   */
  int countShopAdsPage(@Param("adsShopId") Long adsShopId,
                       @Param("verify") Integer verify,
                       @Param("status") Integer status,
                       @Param("title") String title);
  
  /**
   * 
   * @date:   2018年7月11日 下午2:44:04  
   * @Title: findShopAdsList   
   * @Description: TODO(查询投放列表)   
   * @param adsShopId
   * @param verify
   * @param status
   * @param title
   * @return      
   * @return: List<ShopAds>       
   *
   */
  List<ShopAds> findShopAdsList(@Param("adsShopId") Long adsShopId,
                                    @Param("verify") Integer verify,
                                    @Param("status") Integer status,
                                    @Param("title") String title);
  
  /**
   * 
   * @date:   2018年7月18日 下午2:13:59  
   * @Title: getShopAdsDetailById   
   * @Description: TODO(根据主键查询投放详情)   
   * @param id
   * @return      
   * @return: ShopAds      
   *
   */
  ShopAds getShopAdsDetailById(@Param("id") long id);
}
