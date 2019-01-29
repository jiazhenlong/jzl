package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {

  /**
   * 订单状态,0:待付款
   */
  WAITING_PAYMENT(0, "待付款"),
  
  /**
   * 订单状态,1:待消费
   */
  WAITING_TRADING(1, "待消费"),

  /**
   * 订单状态,2:交易完成
   */
  TRADING_END(2, "交易完成"),
  
  /**
   * 订单状态：3:交易关闭
   */
  TRADING_CLOSED(3, "交易关闭");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (OrderStatus type : OrderStatus.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private static Map<Integer, OrderStatus> cacheEnum = new HashMap<Integer, OrderStatus>();
  
  static {
    for (OrderStatus type : OrderStatus.values()) {
      cacheEnum.put(type.getCode(), type);
    }
  }
  
  private Integer code;
  private String name;

  OrderStatus(Integer code, String name) {
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
  
  public static Map<Integer, OrderStatus> getCacheEnum() {
    return cacheEnum;
  }
}
