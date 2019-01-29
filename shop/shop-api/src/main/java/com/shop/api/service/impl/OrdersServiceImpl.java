package com.shop.api.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.api.base.MultiPage;
import com.shop.api.service.OrdersService;
import com.shop.api.vo.OrderDetailVO;
import com.shop.api.vo.OrdersVO;
import com.shop.constant.Constants;
import com.shop.enums.MerchantsType;
import com.shop.enums.OrderSource;
import com.shop.enums.OrderStatus;
import com.shop.exception.ApiException;
import com.shop.exception.Errors;
import com.shop.model.Ads;
import com.shop.model.AdsGoods;
import com.shop.model.Members;
import com.shop.model.Orders;
import com.shop.service.AdsCoreService;
import com.shop.service.AdsGoodsCoreService;
import com.shop.service.MembersCoreService;
import com.shop.service.OrdersCoreService;

/**
 *
 * @Title: OrdersService.java
 * @Package com.shop.api.service.impl
 * @Description: TODO(订单服务类)
 * @author: jiazhenlong
 * @date: 2018年5月28日 下午5:10:33
 * @version V1.0
 * @Copyright: 2018 wehere All rights reserved.
 */
@Service
public class OrdersServiceImpl implements OrdersService {
  private static final Logger LOG = LoggerFactory.getLogger(OrdersServiceImpl.class);

  @Autowired
  private OrdersCoreService ordersCoreService;

  @Autowired
  private AdsGoodsCoreService adsGoodsCoreService;

  @Autowired
  private MembersCoreService membersCoreService;

  @Autowired
  private AdsCoreService adsCoreService;



  @Override
  public void writeOffOrder(String orderSn) {
    Orders orders = ordersCoreService.getOrdersByOrderSn(orderSn)
            .orElseThrow(() -> new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
                    new Object[] {"orderSn:" + orderSn}));

    OrderStatus orderStatus = OrderStatus.getCacheEnum().get(orders.getStatus());

    switch (orderStatus) {
      case WAITING_PAYMENT:
        throw new ApiException(Errors.ApiErrors.WAITING_PAYMENT,
                new Object[] {"orderSn:" + orderSn});

      case WAITING_TRADING:
        ordersCoreService.updateOrderStatusByOrderSn(OrderStatus.TRADING_END.getCode(), orderSn);

        break;
      case TRADING_END:
        throw new ApiException(Errors.ApiErrors.TRADING_END, new Object[] {"orderSn:" + orderSn});

      case TRADING_CLOSED:
        throw new ApiException(Errors.ApiErrors.TRADING_CLOSED,
                new Object[] {"orderSn:" + orderSn});

      default:
        LOG.error(MessageFormat.format("订单核销失败，订单状态错误！orderSn: {0}", orderSn));

        throw new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
                new Object[] {"orderSn:" + orderSn});
    }
  }


  @Override
  public MultiPage<OrdersVO> findFlowOrderPage(Long shopId,
                                               Integer status,
                                               int pageIndex) {

    return findOrderPage(shopId, status, pageIndex, MerchantsType.ADVERTISEMENT_FLOW);
  }


  @Override
  public MultiPage<OrdersVO> findAdsOrderPage(Long shopId,
                                              Integer status,
                                              int pageIndex) {

    return findOrderPage(shopId, status, pageIndex, MerchantsType.ADVERTISEMENT);
  }


  private MultiPage<OrdersVO> findOrderPage(Long shopId,
                                            Integer status,
                                            int pageIndex,
                                            MerchantsType merchantsType) {
    List<OrdersVO> povList = new ArrayList<>();

    int start = (pageIndex - 1) * Constants.PAGE_SIZE;

    ordersCoreService
            .findOrderPage(shopId, status, merchantsType.getCode(), start, Constants.PAGE_SIZE)
            .parallelStream().forEach((order) -> {
              OrdersVO ordersVO = new OrdersVO();

              List<Long> goodsIdList = ordersCoreService.findGoodsIdListByOrderId(order.getId());

              if (CollectionUtils.isEmpty(goodsIdList)) {
                throw new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
                        new Object[] {"订单不存在关联商品, orderSn:" + order.getOrderSn()});
              }
              // 目前广告和商品采用一对一的模式, 故一个订单也对应一个商品, 所以暂取集合第一个值
              AdsGoods adsGoods = adsGoodsCoreService.getAdsGoodsById(goodsIdList.get(0));

              List<String> goodsImgsList =
                      adsGoodsCoreService.findGoodsImagesUrlByGoodsId(goodsIdList.get(0));

              if (CollectionUtils.isEmpty(goodsImgsList) || adsGoods == null) {
                throw new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
                        new Object[] {"订单不存在关联商品或图片, orderSn:" + order.getOrderSn()});
              }

              ordersVO.setGoodsName(adsGoods.getGoodsName());
              ordersVO.setGoodsNumber(adsGoods.getGoodsNumber());
              ordersVO.setGoodsPrice(adsGoods.getGoodsPrice());

              // 按需求取第一个图片
              ordersVO.setImgUrl(goodsImgsList.get(0));
              ordersVO.setOrderSn(order.getOrderSn());
              ordersVO.setStatus(order.getStatus());
              ordersVO.setStatusName(OrderStatus.getCache().get(order.getStatus()));

              switch (merchantsType) {
                case ADVERTISEMENT: // 广告主收入
                  // 实际收入，当广告主和流量主是同一人时实际收入=订单价格-平台佣金
                  if (order.getFlowId().longValue() == shopId.longValue()) {
                    ordersVO.setRealIncome(
                            order.getOrderPrice().subtract(order.getOurCommission()));
                  } else {
                    // 实际收入，当广告主和流量主是同一人时实际收入=订单价格-平台佣金-流量主佣金
                    ordersVO.setRealIncome(order.getOrderPrice().subtract(order.getOurCommission())
                            .subtract(order.getFlowCommission()));
                  }
                  break;

                case ADVERTISEMENT_FLOW: // 流量主收入
                  // 实际收入，当广告主和流量主是同一人时实际收入=订单价格-平台佣金
                  if (order.getAdsShopId() == shopId.longValue()) {
                    ordersVO.setRealIncome(
                            order.getOrderPrice().subtract(order.getOurCommission()));
                  } else {
                    // 实际收入，只是流量主=流量主佣金
                    ordersVO.setRealIncome(order.getFlowCommission());
                  }
                  break;

                default:
                  ordersVO.setRealIncome(order.getOrderPrice().subtract(order.getOurCommission()));
              }

              povList.add(ordersVO);
            });

    int total = ordersCoreService.countOrderPage(shopId, status, merchantsType.getCode());

    return new MultiPage<OrdersVO>((povList.size() + start) < total, povList);
  }


  @Override
  public OrderDetailVO getAdsOrderDetail(String orderSn) {
    Orders order = ordersCoreService.getAdsOrderDetail(orderSn)
            .orElseThrow(() -> new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
                    new Object[] {"订单信息不存在, orderSn:" + orderSn}));

    return getOrderDetailVO(orderSn, order, MerchantsType.ADVERTISEMENT);
  }


  private OrderDetailVO getOrderDetailVO(String orderSn,
                                         Orders order,
                                         MerchantsType merchantsType) {
    List<Long> goodsIdList = ordersCoreService.findGoodsIdListByOrderId(order.getId());

    if (CollectionUtils.isEmpty(goodsIdList)) {
      throw new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
              new Object[] {"订单不存在关联商品, orderSn:" + order.getOrderSn()});
    }
    // 目前广告和商品采用一对一的模式, 故一个订单也对应一个商品, 所以暂取集合第一个值
    AdsGoods adsGoods = adsGoodsCoreService.getAdsGoodsById(goodsIdList.get(0));

    List<String> goodsImgsList =
            adsGoodsCoreService.findGoodsImagesUrlByGoodsId(goodsIdList.get(0));

    if (CollectionUtils.isEmpty(goodsImgsList) || adsGoods == null) {
      throw new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
              new Object[] {"订单不存在关联商品或图片, orderSn:" + order.getOrderSn()});
    }


    Members members = membersCoreService.getMembersById(order.getMemberId())
            .orElseThrow(() -> new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
                    new Object[] {"买家信息不存在, orderSn:" + orderSn}));


    Ads ads = adsCoreService.getAdsShopByAdsId(order.getAdsId())
            .orElseThrow(() -> new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
                    new Object[] {"广告或商家信息不存在, orderSn:" + orderSn}));


    OrderDetailVO orderDetailVO = new OrderDetailVO();
    BeanUtils.copyProperties(order, orderDetailVO);

    orderDetailVO.setUsername(members.getUsername());

    orderDetailVO.setShopName(ads.getShopName());
    orderDetailVO.setAdsName(ads.getTitle());

    switch (merchantsType) {
      case ADVERTISEMENT: // 广告主
        
        orderDetailVO.setMobile(members.getMobile());
        
        // 实际收入，当广告主和流量主是同一人时实际收入=订单价格-平台佣金
        if (order.getFlowId().longValue() == order.getAdsShopId()) {
          orderDetailVO.setRealIncome(order.getOrderPrice().subtract(order.getOurCommission()));
        } else {
          // 实际收入，当广告主和流量主是同一人时实际收入=订单价格-平台佣金-流量主佣金
          orderDetailVO.setRealIncome(order.getOrderPrice().subtract(order.getOurCommission())
                  .subtract(order.getFlowCommission()));
        }
        break;

      case ADVERTISEMENT_FLOW: // 流量主收入
        // 实际收入，当广告主和流量主是同一人时实际收入=订单价格-平台佣金
        if (order.getAdsShopId() == order.getAdsShopId()) {
          orderDetailVO.setRealIncome(order.getOrderPrice().subtract(order.getOurCommission()));
        } else {
          // 实际收入，只是流量主=流量主佣金
          orderDetailVO.setRealIncome(order.getFlowCommission());
        }
        break;

      default:
        orderDetailVO.setRealIncome(order.getOrderPrice().subtract(order.getOurCommission()));
    }
    orderDetailVO.setGoodsName(adsGoods.getGoodsName());
    orderDetailVO.setGoodsNumber(adsGoods.getGoodsNumber());
    orderDetailVO.setGoodsPrice(adsGoods.getGoodsPrice());
    orderDetailVO.setStartTimeStr(DateFormatUtils.ISO_DATE_FORMAT.format(adsGoods.getStartTime()));
    orderDetailVO.setEndTimeStr(DateFormatUtils.ISO_DATE_FORMAT.format(adsGoods.getStartTime()));
    orderDetailVO.setGoodsAddress(adsGoods.getAddress());

    // 按需求取第一个图片
    orderDetailVO.setImgUrl(goodsImgsList.get(0));
    orderDetailVO.setStatusName(OrderStatus.getCache().get(order.getStatus()));
    orderDetailVO.setOrderSource(OrderSource.getCache().get(order.getOrderSource()));
    orderDetailVO.setCreatedTimeStr(DateFormatUtils.ISO_DATETIME_FORMAT.format(order.getCreatedTime()));

    if (OrderStatus.TRADING_END.getCode() == order.getStatus()) {
      orderDetailVO.setCompleteTimeStr(DateFormatUtils.ISO_DATETIME_FORMAT.format(order.getCompleteTime()));
    }

    return orderDetailVO;
  }


  @Override
  public OrderDetailVO getFlowOrderDetail(String orderSn) {
    Orders order = ordersCoreService.getFlowOrderDetail(orderSn)
            .orElseThrow(() -> new ApiException(Errors.ApiErrors.DATA_NOT_EXIST,
                    new Object[] {"订单信息不存在, orderSn:" + orderSn}));

    return getOrderDetailVO(orderSn, order, MerchantsType.ADVERTISEMENT_FLOW);
  }


}
