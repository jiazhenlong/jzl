package com.shop.service;

import java.util.List;
import java.util.Optional;

import com.shop.model.Ads;
import com.shop.model.AdsBrief;
import com.shop.model.AdsImages;

/**  
*
* @Title:  AdsCoreService.java   
* @Package com.shop.service   
* @Description:    TODO(商家广告)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:10:06   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface AdsCoreService {

  
  /**
   * 
   * @date:   2018年6月8日 上午9:32:31  
   * @Title: getAdsById   
   * @Description: TODO(根据主键查询广告信息)   
   * @param id
   * @return      
   * @return: Ads       
   *
   */
  Ads getAdsById(long id);
  
  /**
   * 
   * @date:   2018年6月8日 上午9:56:36  
   * @Title: findAdsListPage   
   * @Description: TODO(获取广告列表) 
   * @param shopId
   * @param sort
   * @param adsName  
   * @param verify
   * @param pageIndex 
   * @param pageSize 
   * @return      
   * @return: List<Ads>       
   *
   */
  List<Ads> findAdsListPage(long shopId, 
                        int sort, 
                        String adsName,
                        Integer verify,
                        int pageIndex,
                        int pageSize);
  
  /**
   * 
   * @date:   2018年6月21日 下午4:03:16  
   * @Title: countAdsPage   
   * @Description: TODO(统计分页数量)   
   * @param shopId
   * @param adsName
   * @param verify
   * @return      
   * @return: int       
   *
   */
  int countAdsPage(long shopId, String adsName, Integer verify);
  
  /**
   * 
   * @date:   2018年6月12日 下午2:28:10  
   * @Title: addAds   
   * @Description: TODO(新增广告)   
   * @param ads      
   * @return: void       
   *
   */
  void addAds(Ads ads);
  
  /**
   * 
   * @date:   2018年6月12日 下午2:28:16  
   * @Title: delAdsById   
   * @Description: TODO(根据主键删除广告)   
   * @param id      
   * @return: void       
   *
   */
  void delAdsById(long id);
  
  /**
   * 
   * @date:   2018年6月12日 上午11:29:48  
   * @Title: addBatchAdsImages   
   * @Description: TODO(批量新增广告图片)   
   * @param adsImagesList      
   * @return: void       
   *
   */
  void addBatchAdsImages(List<AdsImages> adsImagesList);
  
  /**
   * 
   * @date:   2018年6月12日 上午11:41:36  
   * @Title: findAdsImagesByAdsId   
   * @Description: TODO(根据广告id查询广告图片)   
   * @param adsId
   * @return      
   * @return: List<AdsImages>       
   *
   */
  List<AdsImages> findAdsImagesByAdsId(long adsId);
  
  /**
   * 
   * @date:   2018年6月12日 下午3:09:53  
   * @Title: getAdsImagesById   
   * @Description: TODO(根据广告图片id获取图片信息)   
   * @param id
   * @return      
   * @return: AdsImages       
   *
   */
  AdsImages getAdsImagesById(long id);
  
  /**
   * 
   * @date:   2018年6月12日 下午3:09:58  
   * @Title: delAdsImagesById   
   * @Description: TODO(根据主键删除广告图片)   
   * @param id      
   * @return: void       
   *
   */
  void delAdsImagesById(long id);
  
  /**
   * 
   * @date:   2018年6月12日 下午3:10:02  
   * @Title: updateAdsImages   
   * @Description: TODO(修改广告图片信息)   
   * @param adsImages      
   * @return: void       
   *
   */
  void updateAdsImages(AdsImages adsImages);
  
  /**
   * 
   * @date:   2018年6月12日 下午3:10:06  
   * @Title: addAdsImages   
   * @Description: TODO(新增广告图片)   
   * @param adsImages      
   * @return: void       
   *
   */
  void addAdsImages(AdsImages adsImages);
  
  /**
   * 
   * @date:   2018年6月14日 上午9:54:54  
   * @Title: updateAdsImagesByIds   
   * @Description: TODO(根据图片主键修改和广告的映射关系)   
   * @param imgIdList
   * @param adsId      
   * @return: void       
   *
   */
  void updateAdsImagesByIds(List<Long> imgIdList, Long adsId);
  
  /**
   * 
   * @date:   2018年6月19日 下午5:04:14  
   * @Title: findAdsImagesUrlByAdsId   
   * @Description: TODO(根据广告id获取图片地址集合)   
   * @param adsId
   * @return      
   * @return: List<String>       
   *
   */
  List<String> findAdsImagesUrlByAdsId(long adsId);
  
  /**
   * 
   * @date:   2018年6月20日 上午10:47:08  
   * @Title: updateAds   
   * @Description: TODO(修改广告信息)   
   * @param ads      
   * @return:    
   * @return: int    
   *
   */
  int updateAds(Ads ads);
  
  /**
   * 
   * @date:   2018年6月20日 上午10:54:41  
   * @Title: delAdsImagesMapperByAdsId   
   * @Description: TODO(根据广告id删除广告和图片之间的映射关系)   
   * @param adsId      
   * @return: void       
   *
   */
  void delAdsImagesMapperByAdsId(long adsId);

  /**
   * 流量主查询广告列表
   * @param sort
   * @param adsName
   * @param pageIndex
   * @param pageSize
   * @return
   */
  List<AdsBrief> findadsBriefList(int sort, String adsName, int pageIndex, int pageSize);
  
  /**
   * 
   * @date:   2018年7月24日 上午11:54:52  
   * @Title: getAdsShopByAdsId   
   * @Description: TODO(根据广告id获取广告和商家的信息)   
   * @param adsId
   * @return      
   * @return: Ads       
   *
   */
  Optional<Ads> getAdsShopByAdsId(long adsId);
  
  
  
  
  
  
}
