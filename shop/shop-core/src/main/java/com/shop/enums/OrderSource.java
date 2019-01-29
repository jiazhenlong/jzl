package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderSource {

  /**
   * 订单来源,1:TV
   */
  ADVERTISEMENT(1, "TV"),

  /**
   * 订单来源,2:其它
   */
  FLOW(2, "其它");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (OrderSource type : OrderSource.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  OrderSource(Integer code, String name) {
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
