package com.shop.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.Orders;

/**
 *
 * @Title: OrdersDao.java
 * @Package com.shop.dao.mysql
 * @Description: TODO(订单)
 * @author: jiazhenlong
 * @date: 2018年5月25日 上午11:04:32
 * @version V1.0
 * @Copyright: 2018 wehere All rights reserved.
 */
@Repository
public interface OrdersDao {

  /**
   * 
   * @date: 2018年5月28日 下午3:41:25
   * @Title: addOrders
   * @Description: TODO(新增订单信息)
   * @param orders
   * @return: void
   *
   */
  void addOrders(@Param("orders") Orders orders);

  /**
   * 
   * @date: 2018年5月28日 下午3:41:28
   * @Title: getOrdersById
   * @Description: TODO(根据主键获取订单信息)
   * @param id
   * @return
   * @return: Orders
   *
   */
  Orders getOrdersById(@Param("id") long id);

  /**
   * 
   * @date: 2018年5月28日 下午3:41:32
   * @Title: delOrdersById
   * @Description: TODO(根据主键删除订单信息)
   * @param id
   * @return: void
   *
   */
  void delOrdersById(@Param("id") long id);

  /**
   * 
   * @date:   2018年7月20日 下午3:35:49  
   * @Title: findOrderPage   
   * @Description: TODO(分页查询商家列表)   
   * @param shopId
   * @param status
   * @param merchantsType
   * @param pageIndex
   * @param pageSize
   * @return      
   * @return: List<Orders>       
   *
   */
  List<Orders> findOrderPage(@Param("shopId") Long shopId, 
                             @Param("status") Integer status,
                             @Param("merchantsType") int merchantsType,
                             @Param("pageIndex") int pageIndex,
                             @Param("pageSize") int pageSize);

  /**
   * 
   * @date:   2018年7月19日 下午4:48:05  
   * @Title: updateOrderStatusByOrderSn   
   * @Description: TODO(根据订单编号修改订单状态)   
   * @param status
   * @param orderSn      
   * @return: void       
   *
   */
  void updateOrderStatusByOrderSn(@Param("status") Integer status,
                                  @Param("orderSn") String orderSn);

  /**
   * 
   * @date:   2018年7月19日 下午5:15:16  
   * @Title: getOrdersByOrderSn   
   * @Description: TODO(根据订单编号查询订单信息)   
   * @param orderSn
   * @return      
   * @return: Orders       
   *
   */
  Orders getOrdersByOrderSn(@Param("orderSn") String orderSn);
  
  /**
   * 
   * @date:   2018年7月20日 下午5:19:42  
   * @Title: findGoodsIdListByOrderId   
   * @Description: TODO(根据订单id查询关联的商品id集合)   
   * @param ordersId
   * @return      
   * @return: List<Long>       
   *
   */
  List<Long> findGoodsIdListByOrderId(@Param("ordersId") Long ordersId);
  
  /**
   * 
   * @date:   2018年7月20日 下午5:51:31  
   * @Title: countOrderPage   
   * @Description: TODO(分页统计)   
   * @param shopId
   * @param status
   * @param merchantsType
   * @return      
   * @return: int       
   *
   */
  int countOrderPage(@Param("shopId") Long shopId, 
                     @Param("status") Integer status,
                     @Param("merchantsType") int merchantsType);
  
  /**
   * 
   * @date:   2018年7月23日 下午3:56:24  
   * @Title: getAdsOrderDetail   
   * @Description: TODO(获取广告主下的订单信息根据订单编号)   
   * @param orderSn
   * @return      
   * @return: Orders       
   *
   */
  Orders getAdsOrderDetail(@Param("orderSn") String orderSn);
  
  /**
   * 
   * @date:   2018年7月23日 下午3:56:28  
   * @Title: getFlowOrderDetail   
   * @Description: TODO(获取流量主下的订单信息根据订单编号)   
   * @param orderSn
   * @return      
   * @return: Orders       
   *
   */
  Orders getFlowOrderDetail(@Param("orderSn") String orderSn);
}
