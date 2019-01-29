package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum AdsType {

  /**
   * 广告类型: 0-自有商品; 1-他人商品
   */
  OWN_GOODS(0, "自有商品"),
  
  /**
   * 广告类型: 0-自有商品; 1-他人商品
   */
  OTHER_GOODS(1, "他人商品");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (AdsType type : AdsType.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  AdsType(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  public static boolean validate(Integer code) {
    return cache.containsKey(code);
  }

  public Integer getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public static Map<Integer, String> getCache() {
    return cache;
  }
}
