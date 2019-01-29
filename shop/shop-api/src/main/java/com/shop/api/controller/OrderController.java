package com.shop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.service.OrdersService;
import com.shop.api.vo.ResultData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *
 * @Title: OrderController.java
 * @Package com.shop.api.controller
 * @Description: TODO(订单)
 * @author: jiazhenlong
 * @date: 2018年6月11日 上午11:09:04
 * @version V1.0
 * @Copyright: 2018 wehere All rights reserved.
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单API")
public class OrderController {

  @Autowired
  private OrdersService ordersService;



  @ApiOperation("推广订单列表")
  @GetMapping("/flow/list")
  public ResultData findFlowOrderPage(@ApiParam(value = "订单状态 0:待消费 1:交易完成 2:交易关闭") @RequestParam(value = "status", required = false) Integer status,
                                      @ApiParam(value = "流量主门店ID", required = true) @RequestParam(value = "shopId", required = true) Long shopId,
                                      @ApiParam("页码，从1开始") @RequestParam(value = "pageIndex", required = true) int pageIndex) {

    return new ResultData(ordersService.findFlowOrderPage(shopId, status, pageIndex));
  }

  
  @ApiOperation("推广订单详情")
  @GetMapping("/flow/detail")
  public ResultData getFlowOrderDetail(@ApiParam(value = "订单编号") @RequestParam(value = "orderSn", required = false) String orderSn) {

    return new ResultData(ordersService.getFlowOrderDetail(orderSn));
  }

  
  @ApiOperation("销售订单列表")
  @GetMapping("/ads/list")
  public ResultData findAdsOrderPage(@ApiParam(value = "订单状态 0:待消费 1:交易完成 2:交易关闭") @RequestParam(value = "status", required = false) Integer status,
                                     @ApiParam(value = "广告主门店ID", required = true) @RequestParam(value = "shopId", required = true) Long shopId,
                                     @ApiParam("页码，从1开始") @RequestParam(value = "pageIndex", required = true) int pageIndex) {

    return new ResultData(ordersService.findAdsOrderPage(shopId, status, pageIndex));
  }

  @ApiOperation("销售订单详情")
  @GetMapping("/ads/detail")
  public ResultData getAdsOrderDetail(@ApiParam(value = "订单编号") @RequestParam(value = "orderSn", required = false) String orderSn) {

    return new ResultData(ordersService.getAdsOrderDetail(orderSn));
  }

  @ApiOperation("订单核销")
  @PostMapping("/write-off/{orderSn}")
  public ResultData writeOffOrder(@ApiParam(value = "订单编号", required = true) @PathVariable(value = "orderSn", required = true) String orderSn) {
    ordersService.writeOffOrder(orderSn);

    return new ResultData(true);
  }

}
