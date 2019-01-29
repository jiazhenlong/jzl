package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum Gender {

  /**
   * 性别,0:未知
   */
  UNKNOWN(0, "未知"),

  /**
   * 性别,1:男性
   */
  MALE(1, "男性"),

  /**
   * 性别：2:女性
   */
  FEMALE(2, "女性");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (Gender type : Gender.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  Gender(Integer code, String name) {
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
