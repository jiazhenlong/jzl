package com.shop.dao.es.doc;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elasticsearch.common.geo.GeoPoint;

public class MerchantShopEsDoc {

	/**
	 * 门店id
	 */
	private Long shop_id;
	/**
	 * 门店名称
	 */
	private String name;
	/**
	 * 集团id
	 */
	private Long merchant_id;
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

	public Long getShop_id() {
		return shop_id;
	}

	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(Long merchant_id) {
		this.merchant_id = merchant_id;
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
