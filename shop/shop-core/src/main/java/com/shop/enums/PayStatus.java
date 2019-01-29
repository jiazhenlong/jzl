package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum PayStatus {

  /**
   * 支付状态,0:未支付
   */
  UNPAY(0, "未支付"),

  /**
   * 支付状态,1:已支付
   */
  PAYED(1, "已支付");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (PayStatus type : PayStatus.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  PayStatus(Integer code, String name) {
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
