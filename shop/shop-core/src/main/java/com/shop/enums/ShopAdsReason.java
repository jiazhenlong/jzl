package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum ShopAdsReason {

  /**
   * 拒绝原因,0:不符国家要求
   */
  UNCONVENTIONAL(0, "不符国家要求"),

  /**
   * 拒绝原因,1:不喜欢
   */
  DISLIKE(1, "不喜欢"),

  /**
   * 拒绝原因：2:佣金未达要求
   */
  COMMISSION_LITTLE(2, "佣金未达要求");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (ShopAdsReason type : ShopAdsReason.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  ShopAdsReason(Integer code, String name) {
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
