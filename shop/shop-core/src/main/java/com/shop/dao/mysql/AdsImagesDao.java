package com.shop.dao.mysql;

import com.shop.model.AdsImages;

public interface AdsImagesDao {

    int insert(AdsImages record);

    AdsImages selectByPrimaryKey(Integer id);

}