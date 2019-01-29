package com.shop.api.service.impl;

import java.text.MessageFormat;

import org.apache.commons.lang.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.shop.api.service.AdsGoodsService;
import com.shop.api.vo.AdsGoodsBO;
import com.shop.api.vo.AdsGoodsVO;
import com.shop.exception.ApiException;
import com.shop.exception.Errors;
import com.shop.model.AdsGoods;
import com.shop.service.AdsGoodsCoreService;


/**  
*
* @Title:  AdsGoodsServiceImpl.java   
* @Package com.shop.api.service.impl   
* @Description:    TODO(商品服务类)   
* @author: jiazhenlong     
* @date:   2018年6月12日 下午5:03:13   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class AdsGoodsServiceImpl implements AdsGoodsService {

  private static final Logger LOG = LoggerFactory.getLogger(AdsGoodsServiceImpl.class);
  
  @Autowired
  private AdsGoodsCoreService adsGoodsCoreService;
  
  
  
  
  
  
  @Transactional
  @Override
  public Long createAdsGoods(AdsGoodsBO adsGoodsBO) {
    AdsGoods adsGoods = new AdsGoods();
    
    BeanUtils.copyProperties(adsGoodsBO, adsGoods);
    
    adsGoods.setCreatedTime(DateTime.now().toDate());
    adsGoods.setUpdatedTime(DateTime.now().toDate());
    
    adsGoodsCoreService.addAdsGoods(adsGoods);
    
    LOG.info(MessageFormat.format("新增商品成功,{0}", adsGoods));
    
    if (CollectionUtils.isEmpty(adsGoodsBO.getImgIdList())) {
      throw new ApiException(Errors.ApiErrors.GOODS_IMGID_NOT_EXIST, new Object[] {"adsGoodsBO:" + adsGoodsBO});
    }
    
    adsGoodsCoreService.updateGoodsImagesByIds(adsGoodsBO.getImgIdList(), adsGoods.getId(), adsGoodsBO.getDescription());
    
    return adsGoods.getId();
  }




  @Override
  public AdsGoodsVO getGoodsDetail(long adsId) {
    AdsGoodsVO adsGoodsVO = new AdsGoodsVO();
    
    AdsGoods adsGoods = adsGoodsCoreService.getAdsGoodsByAdsId(adsId);
    
    BeanUtils.copyProperties(adsGoods, adsGoodsVO);
    
    if (adsGoods.getStartTime() != null) {
      adsGoodsVO.setStartTimeStr(DateFormatUtils.ISO_DATE_FORMAT.format(adsGoods.getStartTime()));
      adsGoodsVO.setEndTimeStr(DateFormatUtils.ISO_DATE_FORMAT.format(adsGoods.getStartTime()));
    }
    
    adsGoodsVO.setImgUrlList(adsGoodsCoreService.findGoodsImagesUrlByGoodsId(adsGoods.getId()));
    
    return adsGoodsVO;
  }




  @Override
  public void updateAdsGoods(AdsGoodsBO adsGoodsBO) {
    AdsGoods adsGoods = new AdsGoods();
    
    BeanUtils.copyProperties(adsGoodsBO, adsGoods);
    adsGoods.setUpdatedTime(DateTime.now().toDate());
    
    int count = adsGoodsCoreService.updateAdsGoods(adsGoods);
    
    if (count < 1) {
      LOG.error(MessageFormat.format("商品编辑失败,adsGoodsBO:{0}", adsGoodsBO));
      throw new ApiException(Errors.ApiErrors.VERSION_IS_LOW, new Object[] {"adsGoodsBO:" + adsGoodsBO});
    }
    
    adsGoodsCoreService.delAdsGoodsImagesMapperByAdsGoodsId(adsGoods.getId());
    adsGoodsCoreService.updateGoodsImagesByIds(adsGoodsBO.getImgIdList(), adsGoods.getId(), adsGoodsBO.getDescription());
  }

}
