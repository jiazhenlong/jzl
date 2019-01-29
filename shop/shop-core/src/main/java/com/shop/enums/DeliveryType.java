package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum DeliveryType {

  /**
   * 配送方式,0:到店消费
   */
  ARRIVE_SHOP(0, "到店消费"),

  /**
   * 配送方式,1:配送到家
   */
  DELIVERY_HOME(1, "配送到家");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (DeliveryType type : DeliveryType.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  DeliveryType(Integer code, String name) {
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
