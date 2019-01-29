package com.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.mysql.AdsDao;
import com.shop.model.Ads;
import com.shop.model.AdsBrief;
import com.shop.model.AdsImages;
import com.shop.service.AdsCoreService;

@Service
public class AdsCoreServiceImpl implements AdsCoreService {

  @Autowired
  private AdsDao adsDao;
  
  
  
  
  
  @Override
  public Ads getAdsById(long id) {
    return adsDao.getAdsById(id);
  }



  @Override
  public void addAds(Ads ads) {
    adsDao.addAds(ads);    
  }



  @Override
  public void delAdsById(long id) {
    adsDao.delAdsById(id);    
  }



  @Override
  public void addBatchAdsImages(List<AdsImages> adsImagesList) {
    adsDao.addBatchAdsImages(adsImagesList);    
  }



  @Override
  public List<AdsImages> findAdsImagesByAdsId(long adsId) {
    return adsDao.findAdsImagesByAdsId(adsId);
  }



  @Override
  public AdsImages getAdsImagesById(long id) {
    return adsDao.getAdsImagesById(id);
  }



  @Override
  public void delAdsImagesById(long id) {
    adsDao.delAdsImagesById(id);    
  }



  @Override
  public void updateAdsImages(AdsImages adsImages) {
    adsDao.updateAdsImages(adsImages);    
  }



  @Override
  public void addAdsImages(AdsImages adsImages) {
    adsDao.addAdsImages(adsImages);    
  }



  @Override
  public void updateAdsImagesByIds(List<Long> imgIdList,
                                   Long adsId) {
    adsDao.updateAdsImagesByIds(imgIdList, adsId);    
  }



  @Override
  public List<String> findAdsImagesUrlByAdsId(long adsId) {
    return adsDao.findAdsImagesUrlByAdsId(adsId);
  }



  @Override
  public int updateAds(Ads ads) {
    return adsDao.updateAds(ads);    
  }



  @Override
  public void delAdsImagesMapperByAdsId(long adsId) {
    adsDao.delAdsImagesMapperByAdsId(adsId);
  }



  @Override
  public List<Ads> findAdsListPage(long shopId,
                               int sort,
                               String adsName,
                               Integer verify,
                               int pageIndex,
                               int pageSize) {
    return adsDao.findAdsListPage(shopId, sort, adsName, verify, pageIndex, pageSize);
  }



  @Override
  public int countAdsPage(long shopId, String adsName, Integer verify) {
    return adsDao.countAdsPage(shopId, adsName, verify);
  }



	@Override
	public List<AdsBrief> findadsBriefList(int sort, String adsName, int pageIndex, int pageSize) {
		return adsDao.findadsBriefList(sort, adsName, pageIndex, pageSize);
	}



  @Override
  public Optional<Ads> getAdsShopByAdsId(long adsId) {
    return Optional.ofNullable(adsDao.getAdsShopByAdsId(adsId));
  }

}
