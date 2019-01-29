package com.shop.api.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.shop.api.base.MultiPage;
import com.shop.api.service.ShopAdsService;
import com.shop.api.vo.ShopAdsBO;
import com.shop.api.vo.ShopAdsBaseBO;
import com.shop.api.vo.ShopAdsBatchBO;
import com.shop.api.vo.ShopAdsVO;
import com.shop.api.vo.ShopScreenMapperBO;
import com.shop.constant.Constants;
import com.shop.enums.AdsDeliverAction;
import com.shop.enums.ShopAdsStatus;
import com.shop.enums.VerifyStatus;
import com.shop.exception.ApiException;
import com.shop.exception.Errors;
import com.shop.model.AdsScreen;
import com.shop.model.ShopAds;
import com.shop.service.ShopAdsCoreService;
import com.shop.service.ShopScreenCoreService;


/**  
*
* @Title:  ShopAdsServiceImpl.java   
* @Package com.shop.api.service.impl   
* @Description:    TODO(广告投放)   
* @author: jiazhenlong     
* @date:   2018年6月25日 下午2:24:59   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class ShopAdsServiceImpl implements ShopAdsService {
  private static final Logger LOG = LoggerFactory.getLogger(ShopAdsServiceImpl.class);

  @Autowired
  private ShopAdsCoreService shopAdsCoreService;

  @Autowired
  private ShopScreenCoreService shopScreenCoreService;



  @Transactional
  @Override
  public void createShopAds(ShopAdsBO shopAdsBO) {
    LOG.info(MessageFormat.format("发布广告：{0}", shopAdsBO));

    saveShopAds(shopAdsBO, Arrays.asList(shopAdsBO.getAdsId()),
            shopAdsBO.getShopScreenMapperBOList());
  }



  @Transactional
  @Override
  public void batchCreateShopAds(ShopAdsBatchBO shopAdsBatchBO) {
    saveShopAds(shopAdsBatchBO, shopAdsBatchBO.getAdsIdList(),
            shopAdsBatchBO.getShopScreenMapperBOList());

  }


  private void saveShopAds(ShopAdsBaseBO shopAdsBaseBO,
                           List<Long> adsIdList,
                           List<ShopScreenMapperBO> shopScreenMapperBOList) {
    for (Long adsId : adsIdList) {
      for (ShopScreenMapperBO sm : shopScreenMapperBOList) {
        ShopAds shopAds = new ShopAds();

        BeanUtils.copyProperties(shopAdsBaseBO, shopAds);
        shopAds.setStatus(ShopAdsStatus.UN_LAUNCH.getCode());
        shopAds.setVerify(VerifyStatus.AUDIT_NOT.getCode());
        shopAds.setShopId(sm.getShopId());
        shopAds.setAdsId(adsId);

        shopAds.setAction(AdsDeliverAction.DELIVER_OWN_ADS.getCode());
        shopAds.setCreatedTime(DateTime.now().toDate());
        shopAds.setUpdatedTime(DateTime.now().toDate());

        shopAdsCoreService.addShopAds(shopAds);
        List<AdsScreen> adsScreenList = new ArrayList<>();

        for (Long screenId : sm.getScreenIdList()) {
          AdsScreen adsScreen = new AdsScreen();
          adsScreen.setShopAdsId(shopAds.getId());
          adsScreen.setShopScreenId(screenId);

          adsScreenList.add(adsScreen);
        }

        shopScreenCoreService.addBatchAdsScreen(adsScreenList);
      }
    }
  }



  @Override
  public MultiPage<ShopAdsVO> findShopAdsListPage(Long adsShopId,
                                                  Integer verify,
                                                  Integer status,
                                                  String title,
                                                  int pageIndex) {
    int start = (pageIndex - 1) * Constants.PAGE_SIZE;

    List<ShopAds> shopAdsList = shopAdsCoreService.findShopAdsListPage(adsShopId, verify, status,
            title, start, Constants.PAGE_SIZE);

    if (CollectionUtils.isEmpty(shopAdsList)) {
      return new MultiPage<ShopAdsVO>();
    }

    int total = shopAdsCoreService.countShopAdsPage(adsShopId, verify, status, title);

    List<ShopAdsVO> shopAdsVOList = new ArrayList<ShopAdsVO>();

    for (ShopAds shopAds : shopAdsList) {

      ShopAdsVO shopAdsVO = new ShopAdsVO();

      BeanUtils.copyProperties(shopAds, shopAdsVO);

      shopAdsVO.setStatusName(ShopAdsStatus.getCache().get(shopAds.getStatus()));
      shopAdsVO.setVerifyName(VerifyStatus.getCache().get(shopAds.getVerify()));
      shopAdsVO.setStartDateStr(DateFormatUtils.ISO_DATE_FORMAT.format(shopAds.getStartDate()));
      shopAdsVO.setEndDateStr(DateFormatUtils.ISO_DATE_FORMAT.format(shopAds.getEndDate()));

      shopAdsVOList.add(shopAdsVO);
    }

    return new MultiPage<ShopAdsVO>((shopAdsList.size() + start) < total, shopAdsVOList);
  }



  @Override
  public void delShopAdsById(long id) {
    shopAdsCoreService.delShopAdsById(id);
  }



  @Override
  public ShopAdsVO getShopAdsDetailById(long id) {
    ShopAds shopAds = shopAdsCoreService.getShopAdsDetailById(id)
            .orElseThrow(() -> new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
                    new Object[] {"id:" + id}));

    ShopAdsVO shopAdsVO = new ShopAdsVO();
    
    BeanUtils.copyProperties(shopAds, shopAdsVO);
  
    shopAdsVO.setStatusName(ShopAdsStatus.getCache().get(shopAds.getStatus()));
    
    return shopAdsVO;
  }

}
