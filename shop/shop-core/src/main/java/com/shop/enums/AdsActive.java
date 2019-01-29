package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum AdsActive {

  /**
   * 广告是否激活,0:否
   */
  ACTIVE_NO(0, "否"),

  /**
   * 广告是否激活,1:是
   */
  ACTIVE_YES(1, "是");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (AdsActive type : AdsActive.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  AdsActive(Integer code, String name) {
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
