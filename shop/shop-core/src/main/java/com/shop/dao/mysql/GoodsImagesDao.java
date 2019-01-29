package com.shop.dao.mysql;

import com.shop.model.GoodsImages;

public interface GoodsImagesDao {
  
  int insert(GoodsImages record);

  GoodsImages selectByPrimaryKey(Integer id);
}
