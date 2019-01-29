package com.shop.api.service;

import java.util.List;

import com.shop.api.base.MultiPage;
import com.shop.api.vo.AdsBO;
import com.shop.api.vo.AdsBriefVO;
import com.shop.api.vo.AdsVO;



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
public interface AdsService {

  /**
   * 
   * @date:   2018年6月21日 上午10:25:07  
   * @Title: findAdsListPage   
   * @Description: TODO(获取广告列表)   
   * @param shopId
   * @param sort
   * @param verify
   * @param adsName
   * @param pageIndex
   * @return      
   * @return: MultiPage<AdsVO>       
   *
   */
  MultiPage<AdsVO> findAdsListPage(long shopId, int sort, Integer verify, String adsName, int pageIndex);

  /**
   * 
   * @date:   2018年6月13日 下午5:39:24  
   * @Title: publishAds   
   * @Description: TODO(发布广告)   
   * @param adsBO      
   * @return: void       
   *
   */
  void publishAds(AdsBO adsBO);

  
  /**
   * 
   * @date:   2018年6月19日 下午2:26:31  
   * @Title: getAdsDetail   
   * @Description: TODO(获取广告详情)   
   * @param adsId
   * @return      
   * @return: AdsVO       
   *
   */
  AdsVO getAdsDetail(long adsId);
  
  /**
   * 
   * @date:   2018年6月20日 上午11:37:54  
   * @Title: updateAds   
   * @Description: TODO(修改广告信息)   
   * @param adsBO
   * @return: void       
   *
   */
  void updateAds(AdsBO adsBO);

  /**
   * 
   * @param sort
   * @param adsName
   * @param pageIndex
   * @return
   */
  List<AdsBriefVO> findAdsBriefList(int sort, String adsName, int pageIndex);
}
