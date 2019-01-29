package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum VerifyStatus {

  /**
   * 审核状态,-1:审核未通过
   */
  AUDIT_FAILED_PASS(-1, "审核未通过"),

  /**
   * 审核状态,0:未审核
   */
  AUDIT_NOT(0, "未审核"),

  /**
   * 审核状态：1:审核通过
   */
  AUDIT_IS_PASS(1, "审核通过");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (VerifyStatus type : VerifyStatus.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  VerifyStatus(Integer code, String name) {
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
