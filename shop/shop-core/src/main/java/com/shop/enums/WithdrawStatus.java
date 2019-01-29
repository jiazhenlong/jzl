package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum WithdrawStatus {

  /**
   * 提现状态,0:待审核
   */
  AUDIT_NOT(0, "待审核"),

  /**
   * 提现状态,1:审核通过提现中
   */
  WITHDRAWING(1, "审核通过提现中"),

  /**
   * 提现状态,2:提现成功
   */
  WITHDRAW_SUCCESS(2, "提现成功"),
  
  /**
   * 提现状态：-1:提现失败
   */
  WITHDRAW_FAILED(-1, "提现失败");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (WithdrawStatus type : WithdrawStatus.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  WithdrawStatus(Integer code, String name) {
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
