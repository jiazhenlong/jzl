package com.shop.api.service;

import com.shop.api.base.MultiPage;
import com.shop.api.vo.ShopAdsBO;
import com.shop.api.vo.ShopAdsBatchBO;
import com.shop.api.vo.ShopAdsVO;

/**  
*
* @Title:  ShopAdsService.java   
* @Package com.shop.api.service   
* @Description:    TODO(广告投放)   
* @author: jiazhenlong     
* @date:   2018年6月25日 下午2:24:42   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface ShopAdsService {

  /**
   * 
   * @date:   2018年6月26日 上午11:07:13  
   * @Title: createShopAds   
   * @Description: TODO(广告投放)   
   * @param shopAdsBO      
   * @return: void       
   *
   */
  void createShopAds(ShopAdsBO shopAdsBO);

  /**
   * 
   * @date:   2018年7月3日 下午3:39:36  
   * @Title: batchCreateShopAds   
   * @Description: TODO(批量投放广告)   
   * @param shopAdsBatchBO      
   * @return: void       
   *
   */
  void batchCreateShopAds(ShopAdsBatchBO shopAdsBatchBO);


  /**
   * 
   * @date:   2018年7月5日 下午3:11:33  
   * @Title: findShopAdsListPage   
   * @Description: TODO(查询投放列表)   
   * @param adsShopId
   * @param verify
   * @param status
   * @param title
   * @param pageIndex
   * @return      
   * @return: MultiPage<ShopAdsVO>       
   *
   */
  MultiPage<ShopAdsVO> findShopAdsListPage(Long adsShopId,
                                  Integer verify,
                                  Integer status,
                                  String title,
                                  int pageIndex);
  
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
   * @return: ShopAdsVO       
   *
   */
  ShopAdsVO getShopAdsDetailById(long id);
}
