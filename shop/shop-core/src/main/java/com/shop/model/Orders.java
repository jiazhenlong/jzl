package com.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @Title: Orders.java
 * @Package com.shop.model
 * @Description: TODO(订单)
 * @author: jiazhenlong
 * @date: 2018年5月25日 上午10:39:17
 * @version V1.0
 * @Copyright: 2018 wehere All rights reserved.
 */
public class Orders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7341236724734121529L;

	/**
	 * 订单自增id
	 */
	private long id;

	/**
	 * 订单所属广告主键
	 */
	private long adsId;
	
	 /**
   * 广告主id
   */
  private long adsShopId;
	
	/**
	 * 广告投放id
	 */
	private Long shopAdsId;
	
	 /**
   * 广告投放名称
   */
  private String shopAdsName;
	
	 /**
   * 消费者id
   */
	private Long memberId;
	
	 /**
   * 流量主id
   */
	private Long flowId;

	/**
	 * 订单号
	 */
	private String orderSn;

	/**
	 * 订单金额
	 */
	private BigDecimal orderPrice;

	/**
	 * 订单状态, 0:待付款  1:待消费 2:交易完成 3:交易关闭
	 */
	private int status;

	/**
	 * 支付状态,0:未支付1:已支付
	 */
	private int payStatus;

	/**
	 * 订单创建时间
	 */
	private Date createdTime;

	/**
	 * 付款时间
	 */
	private Date payTime;

	/**
	 * 修改时间
	 */
	private Date updatedTime;

	/**
	 * 支付编号
	 */
	private String payCode;

	/**
	 * 订单消费地址
	 */
	private String address;

	/**
	 * 订单核销开始时间
	 */
	private Date stime;

	/**
	 * 订单核销结束时间
	 */
	private Date etime;

	/**
	 * 平台佣金
	 */
	private BigDecimal ourCommission;

	/**
	 * 流量主佣金
	 */
	private BigDecimal flowCommission;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 商品价格
	 */
	private BigDecimal goodsPrice;

	/**
	 * 商品数量
	 */
	private int goodsNumber;
	
	/**
	 * 订单来源
	 */
	private int orderSource;
	
	/**
	 * 客户留言
	 */
	private String customerMessage;
	
	/**
	 * 订单完成时间
	 */
	private Date completeTime;
	
  /**
   * 广告佣金比例
   */
  private double adsCommissionRate;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAdsId() {
		return adsId;
	}

	public void setAdsId(long adsId) {
		this.adsId = adsId;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	public BigDecimal getOurCommission() {
		return ourCommission;
	}

	public void setOurCommission(BigDecimal ourCommission) {
		this.ourCommission = ourCommission;
	}

	public BigDecimal getFlowCommission() {
		return flowCommission;
	}

	public void setFlowCommission(BigDecimal flowCommission) {
		this.flowCommission = flowCommission;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public Long getShopAdsId() {
    return shopAdsId;
  }

  public void setShopAdsId(Long shopAdsId) {
    this.shopAdsId = shopAdsId;
  }

  public Long getMemberId() {
    return memberId;
  }

  public void setMemberId(Long memberId) {
    this.memberId = memberId;
  }

  public Long getFlowId() {
    return flowId;
  }

  public void setFlowId(Long flowId) {
    this.flowId = flowId;
  }

  public long getAdsShopId() {
    return adsShopId;
  }

  public void setAdsShopId(long adsShopId) {
    this.adsShopId = adsShopId;
  }

  public int getOrderSource() {
    return orderSource;
  }

  public void setOrderSource(int orderSource) {
    this.orderSource = orderSource;
  }

  public String getCustomerMessage() {
    return customerMessage;
  }

  public void setCustomerMessage(String customerMessage) {
    this.customerMessage = customerMessage;
  }

  public Date getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(Date completeTime) {
    this.completeTime = completeTime;
  }

  public String getShopAdsName() {
    return shopAdsName;
  }

  public void setShopAdsName(String shopAdsName) {
    this.shopAdsName = shopAdsName;
  }

  public double getAdsCommissionRate() {
    return adsCommissionRate;
  }

  public void setAdsCommissionRate(double adsCommissionRate) {
    this.adsCommissionRate = adsCommissionRate;
  }

  @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
