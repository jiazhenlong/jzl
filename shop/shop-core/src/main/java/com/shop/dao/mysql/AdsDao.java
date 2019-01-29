package com.shop.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.Ads;
import com.shop.model.AdsBrief;
import com.shop.model.AdsImages;

/**  
*
* @Title:  AdsDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(商家广告)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:09:00   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface AdsDao {

  /**
   * 
   * @date:   2018年5月28日 下午2:03:46  
   * @Title: addAds   
   * @Description: TODO(新增广告)   
   * @param ads      
   * @return: void       
   *
   */
  void addAds(@Param("ads") Ads ads);
  
  /**
   * 
   * @date:   2018年5月28日 下午2:04:36  
   * @Title: getAdsById   
   * @Description: TODO(根据主键查询广告信息)   
   * @param id
   * @return      
   * @return: Ads       
   *
   */
  Ads getAdsById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年5月28日 下午2:05:26  
   * @Title: delAdsById   
   * @Description: TODO(根据主键删除广告信息)   
   * @param id      
   * @return: void       
   *
   */
  void delAdsById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年6月8日 上午9:56:36  
   * @Title: findAdsListPage   
   * @Description: TODO(获取广告列表) 
   * @param shopId
   * @param sort
   * @param adsName  
   * @param pageIndex 
   * @param pageSize 
   * @return      
   * @return: List<Ads>       
   *
   */
  List<Ads> findAdsListPage(@Param("shopId")long shopId, 
                        @Param("sort")int sort, 
                        @Param("adsName")String adsName,
                        @Param("verify") Integer verify,
                        @Param("pageIndex")int pageIndex,
                        @Param("pageSize")int pageSize);
  
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
  int countAdsPage(@Param("shopId")long shopId, @Param("adsName")String adsName, @Param("verify") Integer verify);
  
  /**
   * 
   * @date:   2018年6月12日 上午11:29:48  
   * @Title: addBatchAdsImages   
   * @Description: TODO(批量新增广告图片)   
   * @param adsImagesList      
   * @return: void       
   *
   */
  void addBatchAdsImages(@Param("adsImagesList") List<AdsImages> adsImagesList);
  
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
  List<AdsImages> findAdsImagesByAdsId(@Param("adsId") long adsId);
  
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
  AdsImages getAdsImagesById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年6月12日 下午3:09:58  
   * @Title: delAdsImagesById   
   * @Description: TODO(根据主键删除广告图片)   
   * @param id      
   * @return: void       
   *
   */
  void delAdsImagesById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年6月12日 下午3:10:02  
   * @Title: updateAdsImages   
   * @Description: TODO(修改广告图片信息)   
   * @param adsImages      
   * @return: void       
   *
   */
  void updateAdsImages(@Param("adsImages") AdsImages adsImages);
  
  /**
   * 
   * @date:   2018年6月12日 下午3:10:06  
   * @Title: addAdsImages   
   * @Description: TODO(新增广告图片)   
   * @param adsImages      
   * @return: void       
   *
   */
  void addAdsImages(@Param("adsImages") AdsImages adsImages);
  
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
  void updateAdsImagesByIds(@Param("imgIdList") List<Long> imgIdList, @Param("adsId") Long adsId);
  
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
  List<String> findAdsImagesUrlByAdsId(@Param("adsId") long adsId);
  
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
  int updateAds(@Param("ads") Ads ads);
  
  /**
   * 
   * @date:   2018年6月20日 上午10:54:41  
   * @Title: delAdsImagesMapperByAdsId   
   * @Description: TODO(根据广告id删除广告和图片之间的映射关系)   
   * @param adsId      
   * @return: void       
   *
   */
  void delAdsImagesMapperByAdsId(@Param("adsId") long adsId);

  /**
   * 查询广告列表
   * @param sort
   * @param adsName
   * @param pageIndex
   * @param pageSize
   * @return
   */
  List<AdsBrief> findadsBriefList(@Param("sort")int sort, @Param("adsName") String adsName, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

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
  Ads getAdsShopByAdsId(@Param("adsId") long adsId);



}
