package com.shop.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.AdsGoods;
import com.shop.model.GoodsImages;

/**  
*
* @Title:  AdsGoodsDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(广告商品)   
* @author: jiazhenlong     
* @date:   2018年6月12日 上午11:09:00   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface AdsGoodsDao {

  /**
   * 
   * @date:   2018年6月12日 上午10:03:46  
   * @Title: addAdsGoods   
   * @Description: TODO(新增广告商品)   
   * @param adsGoods      
   * @return: void       
   *
   */
  void addAdsGoods(@Param("adsGoods") AdsGoods adsGoods);
  
  /**
   * 
   * @date:   2018年6月12日 上午10:04:36  
   * @Title: getAdsGoodsById   
   * @Description: TODO(根据主键查询广告商品信息)   
   * @param id
   * @return      
   * @return: AdsGoods       
   *
   */
  AdsGoods getAdsGoodsById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年6月12日 上午10:05:26  
   * @Title: delAdsGoodsById   
   * @Description: TODO(根据主键删除广告商品信息)   
   * @param id      
   * @return: void       
   *
   */
  void delAdsGoodsById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年6月12日 上午10:56:36  
   * @Title: findAdsGoodsList   
   * @Description: TODO(获取广告商品列表)   
   * @return      
   * @return: List<AdsGoods>       
   *
   */
  List<AdsGoods> findAdsGoodsList();
  
  /**
   * 
   * @date:   2018年6月12日 上午11:06:45  
   * @Title: addBatchGoodsImages   
   * @Description: TODO(批量新增商品图片)   
   * @param goodsImagesList      
   * @return: void       
   *
   */
  void addBatchGoodsImages(@Param("goodsImagesList") List<GoodsImages> goodsImagesList);
  
  /**
   * 
   * @date:   2018年6月12日 上午11:15:40  
   * @Title: findGoodsImagesByGoodsId   
   * @Description: TODO(根据商品id获取商品图片)   
   * @param goodsId
   * @return      
   * @return: List<GoodsImages>       
   *
   */
   List<GoodsImages> findGoodsImagesByGoodsId(@Param("goodsId") long goodsId);
  
   /**
    * 
    * @date:   2018年6月12日 下午4:48:44  
    * @Title: getGoodsImagesById   
    * @Description: TODO(根据商品图片主键获取图片信息)   
    * @param id
    * @return      
    * @return: GoodsImages       
    *
    */
   GoodsImages getGoodsImagesById(@Param("id") long id);
   
   /**
    * 
    * @date:   2018年6月12日 下午4:48:48  
    * @Title: updateGoodsImages  
    * @Description: TODO(修改商品图片信息)   
    * @param goodsImages      
    * @return: void       
    *
    */
   void updateGoodsImages(@Param("goodsImages") GoodsImages goodsImages);
   
   /**
    * 
    * @date:   2018年6月12日 下午4:48:52  
    * @Title: delGoodsImagesById   
    * @Description: TODO(根据商品图片主键删除图片信息)   
    * @param id      
    * @return: void       
    *
    */
   void delGoodsImagesById(@Param("id") long id);
   
   /**
    * 
    * @date:   2018年6月12日 下午4:48:56  
    * @Title: addGoodsImages   
    * @Description: TODO(新增商品图片)   
    * @param goodsImages      
    * @return: void       
    *
    */
   void addGoodsImages(@Param("goodsImages") GoodsImages goodsImages);
   
   /**
    * 
    * @date:   2018年6月14日 上午10:10:41  
    * @Title: updateGoodsImagesByIds   
    * @Description: TODO(根据图片主键集合修改和商品的映射关系)   
    * @param imgIdList
    * @param goodsId  
    * @param imgDesc    
    * @return: void       
    *
    */
   void updateGoodsImagesByIds(@Param("imgIdList") List<Long> imgIdList, 
                               @Param("goodsId") Long goodsId, 
                               @Param("imgDesc") String imgDesc);
   
   /**
    * 
    * @date:   2018年6月19日 下午4:26:36  
    * @Title: getAdsGoodsByAdsId   
    * @Description: TODO(这通过广告id获取商品详情)   
    * @param adsId
    * @return      
    * @return: AdsGoods       
    *
    */
   AdsGoods getAdsGoodsByAdsId(@Param("adsId") long adsId);
   
   /**
    * 
    * @date:   2018年6月19日 下午4:51:13  
    * @Title: findGoodsImagesUrlByGoodsId   
    * @Description: TODO(获取商品对应的图片地址集合)   
    * @param goodsId
    * @return      
    * @return: List<String>       
    *
    */
   List<String> findGoodsImagesUrlByGoodsId(@Param("goodsId") long goodsId);
   
   /**
    * 
    * @date:   2018年6月19日 下午5:37:01  
    * @Title: createAdsAndGoodsMapper   
    * @Description: TODO(创建广告和商品的映射关系)   
    * @param goodsId
    * @param adsId      
    * @return: void       
    *
    */
   void createAdsAndGoodsMapper(@Param("goodsId") long goodsId, @Param("adsId") long adsId);
   
   /**
    * 
    * @date:   2018年6月22日 上午9:46:02  
    * @Title: updateAdsGoods   
    * @Description: TODO(修改商品信息)   
    * @param adsGoods
    * @return      
    * @return: int       
    *
    */
   int updateAdsGoods(@Param("adsGoods") AdsGoods adsGoods);
   
   /**
    * 
    * @date:   2018年6月22日 上午10:48:26  
    * @Title: delAdsGoodsImagesMapperByAdsGoodsId   
    * @Description: TODO(删除商品和图片的映射关系)   
    * @param goodsId      
    * @return: void       
    *
    */
   void delAdsGoodsImagesMapperByAdsGoodsId(@Param("goodsId") long goodsId);
}
