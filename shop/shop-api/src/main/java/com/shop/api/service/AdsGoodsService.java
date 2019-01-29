package com.shop.api.service;

import com.shop.api.vo.AdsGoodsBO;
import com.shop.api.vo.AdsGoodsVO;

/**  
*
* @Title:  AdsGoodsService.java   
* @Package com.shop.api.service   
* @Description:    TODO(商品服务类)   
* @author: jiazhenlong     
* @date:   2018年6月12日 下午5:02:31   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface AdsGoodsService {

  
  
  /**
   * 
   * @date:   2018年6月13日 下午5:08:54  
   * @Title: createAdsGoods   
   * @Description: TODO(新增商品)   
   * @param adsGoodsBO
   * @return      
   * @return: Long       
   *
   */
  Long createAdsGoods(AdsGoodsBO adsGoodsBO);
  
  /**
   * 
   * @date:   2018年6月19日 下午4:18:55  
   * @Title: getGoodsDetail   
   * @Description: TODO(获取广告关联的商品详情)   
   * @param adsId
   * @return      
   * @return: AdsGoodsVO       
   *
   */
  AdsGoodsVO getGoodsDetail(long adsId);
  
  
  /**
   * 
   * @date:   2018年6月22日 上午9:46:02  
   * @Title: updateAdsGoods   
   * @Description: TODO(修改商品信息)   
   * @param adsGoods
   * @return: void       
   *
   */
  void updateAdsGoods(AdsGoodsBO adsGoodsBO);
}
