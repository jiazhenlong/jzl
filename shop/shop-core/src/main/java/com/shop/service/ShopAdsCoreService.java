package com.shop.service;

import java.util.List;
import java.util.Optional;

import com.shop.model.ShopAds;

/**  
*
* @Title:  ShopAdsCoreService.java   
* @Package com.shop.service   
* @Description:    TODO(广告投放)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:15:40   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface ShopAdsCoreService {


  /**
   * 
   * @date:   2018年6月26日 上午10:32:36  
   * @Title: addShopAds   
   * @Description: TODO(新增广告投放信息)   
   * @param shopAds      
   * @return: void       
   *
   */
  void addShopAds(ShopAds shopAds);

  /**
   * 
   * @date:   2018年6月26日 上午10:32:26  
   * @Title: getShopAdsById   
   * @Description: TODO(根据主键获取广告投放信息)   
   * @param id
   * @return      
   * @return: ShopAds       
   *
   */
  ShopAds getShopAdsById(long id);

  /**
   * 
   * @date:   2018年6月26日 下午2:44:53  
   * @Title: addBatchShopAds   
   * @Description: TODO(批量创建广告投放)   
   * @param shopAdsList      
   * @return: void       
   *
   */
  void addBatchShopAds(List<ShopAds> shopAdsList);

  /**
   * 
   * @date:   2018年7月5日 下午3:11:33  
   * @Title: findShopAdsListPage   
   * @Description: TODO(分页查询投放列表)   
   * @param adsShopId
   * @param verify
   * @param status
   * @param title
   * @param pageIndex
   * @param pageSize
   * @return      
   * @return: List<ShopAdsVO>       
   *
   */
  List<ShopAds> findShopAdsListPage(Long adsShopId,
                                Integer verify,
                                Integer status,
                                String title,
                                int pageIndex,
                                int pageSize);
  
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
  int countShopAdsPage(Long adsShopId,
                       Integer verify,
                       Integer status,
                       String title);
  
  /**
   * 
   * @date:   2018年7月11日 下午2:41:47  
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
  List<ShopAds> findShopAdsList(Long adsShopId,
                                    Integer verify,
                                    Integer status,
                                    String title);
  /**
   * 
   * @date:   2018年7月18日 上午10:48:42  
   * @Title: delShopAdsById   
   * @Description: TODO(删除广告投放信息根据主键)   
   * @param id      
   * @return: void       
   *
   */
  void delShopAdsById(long id);
  
  /**
   * 
   * @date:   2018年7月18日 下午2:11:36  
   * @Title: getShopAdsDetailById   
   * @Description: TODO(根据主键查询投放详情)   
   * @param id
   * @return      
   * @return: Optional<ShopAds>       
   *
   */
  Optional<ShopAds> getShopAdsDetailById(long id);
}
