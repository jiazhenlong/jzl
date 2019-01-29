package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.mysql.AdsGoodsDao;
import com.shop.model.AdsGoods;
import com.shop.model.GoodsImages;
import com.shop.service.AdsGoodsCoreService;


/**  
*
* @Title:  AdsGoodsCoreServiceImpl.java   
* @Package com.shop.service.impl   
* @Description:    TODO(广告商品)   
* @author: jiazhenlong     
* @date:   2018年6月12日 上午11:46:45   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class AdsGoodsCoreServiceImpl implements AdsGoodsCoreService {

  @Autowired
  private AdsGoodsDao adsGoodsDao;
  
  
  
  @Override
  public void addAdsGoods(AdsGoods adsGoods) {
    adsGoodsDao.addAdsGoods(adsGoods);    
  }

  @Override
  public AdsGoods getAdsGoodsById(long id) {
    return adsGoodsDao.getAdsGoodsById(id);
  }

  @Override
  public void delAdsGoodsById(long id) {
    adsGoodsDao.delAdsGoodsById(id);    
  }

  @Override
  public List<AdsGoods> findAdsGoodsList() {
    return adsGoodsDao.findAdsGoodsList();
  }

  @Override
  public void addBatchGoodsImages(List<GoodsImages> goodsImagesList) {
    adsGoodsDao.addBatchGoodsImages(goodsImagesList);    
  }

  @Override
  public List<GoodsImages> findGoodsImagesByGoodsId(long goodsId) {
    return adsGoodsDao.findGoodsImagesByGoodsId(goodsId);
  }

  @Override
  public GoodsImages getGoodsImagesById(long id) {
    return adsGoodsDao.getGoodsImagesById(id);
  }

  @Override
  public void updateGoodsImages(GoodsImages goodsImages) {
    adsGoodsDao.updateGoodsImages(goodsImages);    
  }

  @Override
  public void delGoodsImagesById(long id) {
    adsGoodsDao.delGoodsImagesById(id);    
  }

  @Override
  public void addGoodsImages(GoodsImages goodsImages) {
    adsGoodsDao.addGoodsImages(goodsImages);    
  }

  @Override
  public void updateGoodsImagesByIds(List<Long> imgIdList,
                                     Long goodsId,
                                     String imgDesc) {
    adsGoodsDao.updateGoodsImagesByIds(imgIdList, goodsId, imgDesc);    
  }

  @Override
  public AdsGoods getAdsGoodsByAdsId(long adsId) {
    return adsGoodsDao.getAdsGoodsByAdsId(adsId);
  }

  @Override
  public List<String> findGoodsImagesUrlByGoodsId(long goodsId) {
    return adsGoodsDao.findGoodsImagesUrlByGoodsId(goodsId);
  }

  @Override
  public void createAdsAndGoodsMapper(long goodsId,
                                      long adsId) {
    adsGoodsDao.createAdsAndGoodsMapper(goodsId, adsId);    
  }

  @Override
  public int updateAdsGoods(AdsGoods adsGoods) {
    return adsGoodsDao.updateAdsGoods(adsGoods);
  }

  @Override
  public void delAdsGoodsImagesMapperByAdsGoodsId(long goodsId) {
    adsGoodsDao.delAdsGoodsImagesMapperByAdsGoodsId(goodsId);    
  }


}
