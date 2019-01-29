package com.shop.service;

import java.util.List;
import java.util.Optional;

import com.shop.model.Orders;

/**
 *
 * @Title: OrdersCoreService.java
 * @Package com.shop.service
 * @Description: TODO(订单)
 * @author: jiazhenlong
 * @date: 2018年5月25日 上午11:14:26
 * @version V1.0
 * @Copyright: 2018 wehere All rights reserved.
 */
public interface OrdersCoreService {

  /**
   * 
   * @date: 2018年5月28日 下午5:08:14
   * @Title: getOrdersById
   * @Description: TODO(根据主键获取订单信息)
   * @param id
   * @return
   * @return: Optional<Orders>
   *
   */
  Optional<Orders> getOrdersById(long id);

  /**
   * 
   * @date:   2018年7月20日 下午3:11:26  
   * @Title: findOrderPage   
   * @Description: TODO(根据商家主键查询订单列表)   
   * @param shopId
   * @param status
   * @param merchantsType
   * @param pageIndex
   * @param pageSize
   * @return      
   * @return: List<Orders>      
   *
   */
  List<Orders> findOrderPage(Long shopId,
                             Integer status,
                             int merchantsType,
                             int pageIndex,
                             int pageSize);

  /**
   * 
   * @date:   2018年7月23日 下午3:56:24  
   * @Title: getAdsOrderDetail   
   * @Description: TODO(获取广告主下的订单信息根据订单编号)   
   * @param orderSn
   * @return      
   * @return: Optional<Orders>       
   *
   */
  Optional<Orders> getAdsOrderDetail(String orderSn);
  
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
  Optional<Orders> getFlowOrderDetail(String orderSn);

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
  void updateOrderStatusByOrderSn(Integer status,
                                  String orderSn);

  /**
   * 
   * @date:   2018年7月19日 下午5:15:16  
   * @Title: getOrdersByOrderSn   
   * @Description: TODO(根据订单编号查询订单信息)   
   * @param orderSn
   * @return      
   * @return: Optional<Orders>       
   *
   */
  Optional<Orders> getOrdersByOrderSn(String orderSn);

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
  List<Long> findGoodsIdListByOrderId(Long ordersId);

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
  int countOrderPage(Long shopId,
                     Integer status,
                     int merchantsType);
}
