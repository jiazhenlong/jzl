package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum AccountType {

  /**
   * 帐户类型,0:广告主帐户
   */
  ADVERTISEMENT(0, "广告主帐户"),

  /**
   * 帐户类型,1:流量主帐户
   */
  FLOW(1, "流量主帐户");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (AccountType type : AccountType.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  AccountType(Integer code, String name) {
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
