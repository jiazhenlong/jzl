package com.shop.api.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elasticsearch.common.geo.GeoPoint;

public class MerchantShopBrief {

	/**
	 * 门店id
	 */
	private Long shopId;
	/**
	 * 门店名称
	 */
	private String name;
	/**
	 * 集团id
	 */
	private Long merchantId;
	/**
	 * 门店地址
	 */
	private String addr;
	/**
	 * 备注
	 */
	private String comment;
	/**
	 * 地理坐标
	 */
	private GeoPoint location;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public GeoPoint getLocation() {
		return location;
	}

	public void setLocation(GeoPoint location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
