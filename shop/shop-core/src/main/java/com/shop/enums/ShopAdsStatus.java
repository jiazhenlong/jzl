package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum ShopAdsStatus {

  /**
   * 投放状态,0:投放未开始
   */
  UN_LAUNCH(0, "投放未开始"),

  /**
   * 投放状态,1:正常投放
   */
  LAUNCHED(1, "正常投放"),

  /**
   * 投放状态：2:投放结束
   */
  LAUNCH_END(2, "投放结束");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (ShopAdsStatus type : ShopAdsStatus.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  ShopAdsStatus(Integer code, String name) {
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
