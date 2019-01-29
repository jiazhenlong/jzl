package com.shop.api.service;

import com.shop.api.base.MultiPage;
import com.shop.api.vo.OrderDetailVO;
import com.shop.api.vo.OrdersVO;

/**
 *
 * @Title: OrdersService.java
 * @Package com.shop.api.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: jiazhenlong
 * @date: 2018年5月28日 下午5:07:09
 * @version V1.0
 * @Copyright: 2018 wehere All rights reserved.
 */
public interface OrdersService {


	/**
	 * 
	 * @date:   2018年7月20日 下午3:33:23  
	 * @Title: findFlowOrderPage   
	 * @Description: TODO(流量主订单分页查询)   
	 * @param shopId
	 * @param status
	 * @param pageIndex
	 * @return      
	 * @return: MultiPage<OrdersVO>       
	 *
	 */
  MultiPage<OrdersVO> findFlowOrderPage(Long shopId, Integer status, int pageIndex);
	
	/**
	 * 
	 * @date:   2018年7月20日 下午3:33:09  
	 * @Title: findAdsOrderPage   
	 * @Description: TODO(广告主订单分页查询)   
	 * @param shopId
	 * @param status
	 * @param pageIndex
	 * @return      
	 * @return: MultiPage<OrdersVO>       
	 *
	 */
	MultiPage<OrdersVO> findAdsOrderPage(Long shopId, Integer status, int pageIndex);

  /**
   * 
   * @date:   2018年7月23日 下午3:56:24  
   * @Title: getAdsOrderDetail   
   * @Description: TODO(获取广告主下的订单信息根据订单编号)   
   * @param orderSn
   * @return      
   * @return: AdsOrderDetailVO       
   *
   */
	OrderDetailVO getAdsOrderDetail(String orderSn);
  
  /**
   * 
   * @date:   2018年7月23日 下午3:56:28  
   * @Title: getFlowOrderDetail   
   * @Description: TODO(获取流量主下的订单信息根据订单编号)   
   * @param orderSn
   * @return      
   * @return: AdsOrderDetailVO       
   *
   */
	OrderDetailVO getFlowOrderDetail(String orderSn);
	
	/**
	 * 
	 * @date:   2018年7月19日 下午4:59:04  
	 * @Title: writeOffOrder   
	 * @Description: TODO(根据订单编号核销账单)   
	 * @param orderSn      
	 * @return: void       
	 *
	 */
	void writeOffOrder(String orderSn);
}
