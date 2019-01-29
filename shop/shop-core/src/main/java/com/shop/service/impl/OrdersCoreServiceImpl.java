package com.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.mysql.OrdersDao;
import com.shop.model.Orders;
import com.shop.service.OrdersCoreService;

/**
 *
 * @Title: OrdersCoreServiceImpl.java
 * @Package com.shop.service.impl
 * @Description: TODO(订单)
 * @author: jiazhenlong
 * @date: 2018年5月25日 上午11:23:45
 * @version V1.0
 * @Copyright: 2018 wehere All rights reserved.
 */
@Service
public class OrdersCoreServiceImpl implements OrdersCoreService {

  @Autowired
  private OrdersDao ordersDao;

  @Override
  public Optional<Orders> getOrdersById(long id) {
    return Optional.ofNullable(ordersDao.getOrdersById(id));
  }

  @Override
  public List<Orders> findOrderPage(Long shopId,
                                    Integer status,
                                    int merchantsType,
                                    int pageIndex,
                                    int pageSize) {
    return ordersDao.findOrderPage(shopId, status, merchantsType, pageIndex, pageSize);
  }

  @Override
  public void updateOrderStatusByOrderSn(Integer status,
                                         String orderSn) {
    ordersDao.updateOrderStatusByOrderSn(status, orderSn);
  }

  @Override
  public Optional<Orders> getOrdersByOrderSn(String orderSn) {
    return Optional.ofNullable(ordersDao.getOrdersByOrderSn(orderSn));
  }

  @Override
  public List<Long> findGoodsIdListByOrderId(Long ordersId) {
    return ordersDao.findGoodsIdListByOrderId(ordersId);
  }

  @Override
  public int countOrderPage(Long shopId,
                            Integer status,
                            int merchantsType) {
    return ordersDao.countOrderPage(shopId, status, merchantsType);
  }

  @Override
  public Optional<Orders> getAdsOrderDetail(String orderSn) {
    return Optional.ofNullable(ordersDao.getAdsOrderDetail(orderSn));
  }

  @Override
  public Optional<Orders> getFlowOrderDetail(String orderSn) {
    return Optional.ofNullable(ordersDao.getFlowOrderDetail(orderSn));
  }

}
