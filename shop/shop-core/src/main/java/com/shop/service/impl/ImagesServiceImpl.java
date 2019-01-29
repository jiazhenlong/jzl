package com.shop.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.mysql.AdsImagesDao;
import com.shop.dao.mysql.GoodsImagesDao;
import com.shop.enums.ImageRate;
import com.shop.enums.ImageType;
import com.shop.model.AdsImages;
import com.shop.model.GoodsImages;
import com.shop.service.ImagesService;

@Service
public class ImagesServiceImpl implements ImagesService {

  @Autowired
  private AdsImagesDao adsImagesDao;

  @Autowired
  private GoodsImagesDao goodsImagesDao;

  @Override
  public AdsImages selectByPrimaryKey(Integer id) {

    return adsImagesDao.selectByPrimaryKey(id);
  }

  @Override
  public Long insertAds(String targetFileName,
                        ImageType imageType,
                        ImageRate imageRate) {

    AdsImages record = new AdsImages();
    record.setAdsId(-1L);
    record.setImgUrl(targetFileName);
    record.setType((byte) imageType.ordinal());
    Date timeFlag = new Date();
    record.setCreatedTime(timeFlag);
    record.setUpdatedTime(timeFlag);
    adsImagesDao.insert(record);
    return record.getId();



  }

  @Override
  public Long insertGoods(String targetFileName,
                          ImageType imageType,
                          ImageRate imageRate) {
    GoodsImages record = new GoodsImages();
    record.setGoodsId(-1L);
    record.setImgUrl(targetFileName);
    Date timeFlag = new Date();
    record.setCreatedTime(timeFlag);
    record.setUpdatedTime(timeFlag);
    goodsImagesDao.insert(record);
    return record.getId();
  }

}
