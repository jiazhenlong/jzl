package com.shop.service;


import com.shop.enums.ImageRate;
import com.shop.enums.ImageType;
import com.shop.model.AdsImages;

public interface ImagesService {

  AdsImages selectByPrimaryKey(Integer id);



  Long insertAds(String targetFileName,
                 ImageType imageType,
                 ImageRate imageRate);

  Long insertGoods(String targetFileName,
                   ImageType imageType,
                   ImageRate imageRate);



}
