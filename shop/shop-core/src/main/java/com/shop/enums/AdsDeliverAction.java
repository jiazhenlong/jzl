package com.shop.enums;

import java.util.HashMap;
import java.util.Map;

public enum AdsDeliverAction {

  /**
   * 投放动作 ,0:广告主主动投 
   */
  DELIVER_OWN_ADS(0, "广告主投放广告 "),

  /**
   * 投放动作,1:流量主主动接
   */
  DELIVER_OWN_FLOW(1, "流量主主动接广告");

  private static Map<Integer, String> cache = new HashMap<Integer, String>();

  static {
    for (AdsDeliverAction type : AdsDeliverAction.values()) {
      cache.put(type.getCode(), type.getName());
    }
  }

  private Integer code;
  private String name;

  AdsDeliverAction(Integer code, String name) {
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
