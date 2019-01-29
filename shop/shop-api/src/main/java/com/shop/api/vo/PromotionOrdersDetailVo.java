package com.shop.api.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class PromotionOrdersDetailVo {

	/**
	 * 订单自增id
	 */
	private long id;

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
	 * 商品总价
	 */
	private int GoodsTotal;

	/**
	 * 订单金额
	 */
	private BigDecimal orderPrice;

	/**
	 * 优惠金额
	 */
	private BigDecimal preferential;

	/**
	 * 流量主佣金
	 */
	private BigDecimal flowCommission;

	/**
	 * 广告分佣比例
	 */
	private String rate;

	/**
	 * 图片url
	 */
	private String imgUrl;

	/**
	 * 广告名称
	 */
	private String adsTitle;

	/**
	 * 投放名称
	 */
	private String promotionTitle;

	/**
	 * 商品销售店铺名称
	 */
	private String shopName;

	/**
	 * 商家名称
	 */
	private String merchantName;

	/**
	 * 订单号
	 */
	private String orderSn;

	/**
	 * 订单创建时间
	 */
	private Date createdTime;

	/**
	 * 订单完成时间
	 */
	private Date completeTime;

	/**
	 * 买家账号
	 */
	private String username;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getGoodsTotal() {
		return GoodsTotal;
	}

	public void setGoodsTotal(int goodsTotal) {
		GoodsTotal = goodsTotal;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public BigDecimal getPreferential() {
		return preferential;
	}

	public void setPreferential(BigDecimal preferential) {
		this.preferential = preferential;
	}

	public BigDecimal getFlowCommission() {
		return flowCommission;
	}

	public void setFlowCommission(BigDecimal flowCommission) {
		this.flowCommission = flowCommission;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getAdsTitle() {
		return adsTitle;
	}

	public void setAdsTitle(String adsTitle) {
		this.adsTitle = adsTitle;
	}

	public String getPromotionTitle() {
		return promotionTitle;
	}

	public void setPromotionTitle(String promotionTitle) {
		this.promotionTitle = promotionTitle;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
