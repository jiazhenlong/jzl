package com.shop.api.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.shop.api.base.MultiPage;
import com.shop.api.service.AdsService;
import com.shop.api.vo.AdsBO;
import com.shop.api.vo.AdsBriefVO;
import com.shop.api.vo.AdsVO;
import com.shop.constant.Constants;
import com.shop.enums.AdsType;
import com.shop.enums.CosType;
import com.shop.enums.VerifyStatus;
import com.shop.exception.ApiException;
import com.shop.exception.Errors;
import com.shop.model.Ads;
import com.shop.model.AdsBrief;
import com.shop.service.AdsCoreService;
import com.shop.service.AdsGoodsCoreService;


/**  
*
* @Title:  AdsCoreServiceImpl.java   
* @Package com.shop.service.impl   
* @Description:    TODO(商家广告)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:19:16   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class AdsServiceImpl implements AdsService {
  private static final Logger LOG = LoggerFactory.getLogger(AdsServiceImpl.class);
  
  
  @Autowired
  private AdsCoreService adsCoreService;
  
  @Autowired
  private AdsGoodsCoreService adsGoodsCoreService;
  
  @Value("${our.commission.rate}")
  private double ourCommissionRate;
  


  @Override
  public MultiPage<AdsVO> findAdsListPage(long shopId,
                                 int sort,
                                 Integer verify,
                                 String adsName,
                                 int pageIndex) {
    int start = (pageIndex - 1) * Constants.PAGE_SIZE;
    
    List<Ads> adsList = adsCoreService.findAdsListPage(shopId, sort, adsName, verify, start, Constants.PAGE_SIZE);
    
    if (CollectionUtils.isEmpty(adsList)) {
      return new MultiPage<AdsVO>();
    }
    
    int total = adsCoreService.countAdsPage(shopId, adsName, verify);
    
    List<AdsVO> adsVOList = new ArrayList<AdsVO>();
    
    for (Ads ads : adsList) {
      
      adsVOList.add(wrapAdsVO(ads));
    }
    
    return new MultiPage<AdsVO>((adsList.size() + start) < total, adsVOList);
  }
  
  
  @Transactional
  @Override
  public void publishAds(AdsBO adsBO) {
    Ads ads = new Ads();
    
    BeanUtils.copyProperties(adsBO, ads);
    
    ads.setCreatedTime(DateTime.now().toDate());
    ads.setUpdatedTime(DateTime.now().toDate());
    ads.setVerify(VerifyStatus.AUDIT_NOT.getCode());
    ads.setOurCommissionRate(ourCommissionRate);
    
    adsCoreService.addAds(ads);
    
    if (CollectionUtils.isEmpty(adsBO.getImgIdList())) {
      LOG.error(MessageFormat.format("新增广告失败,{0}", ads));
      
      throw new ApiException(Errors.ApiErrors.ADS_IMGID_NOT_EXIST, new Object[] {"adsBO:" + adsBO});
    }
    
    adsCoreService.updateAdsImagesByIds(adsBO.getImgIdList(), ads.getId());
    
    adsGoodsCoreService.createAdsAndGoodsMapper(adsBO.getGoodsId(), ads.getId());
  }



  @Override
  public AdsVO getAdsDetail(long adsId) {
    return wrapAdsVO(adsCoreService.getAdsById(adsId));
  }


  private AdsVO wrapAdsVO(Ads ads) {
    AdsVO adsVO = new AdsVO();
    
    BeanUtils.copyProperties(ads, adsVO);
    
    adsVO.setAdsTypeName(AdsType.getCache().get(ads.getAdsType()));
    adsVO.setVerifyName(VerifyStatus.getCache().get(ads.getVerify()));
    adsVO.setCosTypeName(CosType.getCache().get(ads.getCosType()));
    
    adsVO.setImgUrlList(adsCoreService.findAdsImagesUrlByAdsId(ads.getId()));
    return adsVO;
  }


  @Transactional
  @Override
  public void updateAds(AdsBO adsBO) {
    Ads adsOld = adsCoreService.getAdsById(adsBO.getId());
    
    if (adsOld == null || adsBO.getVerify() == null
            || adsOld.getVerify().intValue() == VerifyStatus.AUDIT_FAILED_PASS.getCode().intValue()) {
      
      LOG.error(MessageFormat.format("广告编辑失败,adsOld:{0}; adsBO:{1}", adsOld, adsBO));
      throw new ApiException(Errors.ApiErrors.UPDATE_DATA_IS_ERROR, new Object[] {"adsBO:" + adsBO});
    }
    
    Ads ads = new Ads();
    
    if (adsOld.getVerify().intValue() == VerifyStatus.AUDIT_IS_PASS.getCode().intValue()) {
      ads.setId(adsBO.getId());
      ads.setTitle(adsBO.getTitle());
    }
    
    if (adsOld.getVerify().intValue() == VerifyStatus.AUDIT_NOT.getCode().intValue()) {
      BeanUtils.copyProperties(adsBO, ads);
    }
    
    ads.setUpdatedTime(DateTime.now().toDate());
    ads.setVersion(adsBO.getVersion());
    
    int count = adsCoreService.updateAds(ads);
    
    if (count < 1) {
      LOG.error(MessageFormat.format("广告编辑失败,adsOld:{0}; adsBO:{1}", adsOld, adsBO));
      throw new ApiException(Errors.ApiErrors.VERSION_IS_LOW, new Object[] {"adsBO:" + adsBO});
    }
    
    //删除旧的映射关系，建立新的映射关系
    adsCoreService.delAdsImagesMapperByAdsId(adsBO.getId());
    adsCoreService.updateAdsImagesByIds(adsBO.getImgIdList(), ads.getId());
  }


	@Override
	public List<AdsBriefVO> findAdsBriefList(int sort, String adsName, int pageIndex) {
		int start = (pageIndex - 1) * Constants.PAGE_SIZE;
		List<AdsBrief> adsBriefs = adsCoreService.findadsBriefList(sort, adsName, start, Constants.PAGE_SIZE);
		List<AdsBriefVO> adsBriefVOs = new ArrayList<>();
		for(AdsBrief ads:adsBriefs) {
			AdsBriefVO adsBriefVO = new AdsBriefVO();
			BeanUtils.copyProperties(ads, adsBriefVO);
			adsBriefVOs.add(adsBriefVO);
		}
		return adsBriefVOs;
	}

}
