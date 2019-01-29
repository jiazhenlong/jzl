package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum AccountOperation {

  /**
   * 帐户变动操作符,+:收入
   */
  ADD("+", "收入"),

  /**
   * 帐户变动操作符,-:支出
   */
  MINUS ("-", "支出");

  private static Map<String, String> cache = new HashMap<>();

  static {
    for (AccountOperation type : AccountOperation.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private String code;
  private String name;

  AccountOperation(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public static boolean validate(String code) {
    return cache.containsKey(code);
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public static Map<String, String> getCache() {
    return cache;
  }
}
