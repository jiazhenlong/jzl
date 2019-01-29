package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum MerchantsType {

  /**
   * 商家类型,0:广告主、流量主
   */
  ADVERTISEMENT_FLOW(0, "两者"),
  
  /**
   * 商家类型,1:广告主
   */
  ADVERTISEMENT(1, "广告主"),

  /**
   * 商家类型：2:流量主
   */
  FLOW(2, "流量主");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (MerchantsType type : MerchantsType.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  MerchantsType(Integer code, String name) {
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
