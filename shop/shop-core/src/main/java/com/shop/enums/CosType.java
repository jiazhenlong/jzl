package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum CosType {

  /**
   * 出价方式,0:cps
   */
  CPS(0, "cps");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (CosType type : CosType.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  CosType(Integer code, String name) {
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
