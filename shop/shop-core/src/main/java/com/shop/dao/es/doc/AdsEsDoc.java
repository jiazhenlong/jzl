package com.shop.dao.es.doc;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AdsEsDoc {
	/**
	   * 
	   */
	private Long ads_id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 跳转地址
	 */
	private String url;

	/**
	 * 
	 */
	private String image_url;

	/**
	 * 流量主佣金比例
	 */
	private float commission_rate;

	/**
	 * 备注信息
	 */
	private String comment;

	public Long getAds_id() {
		return ads_id;
	}

	public void setAds_id(Long ads_id) {
		this.ads_id = ads_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public float getCommission_rate() {
		return commission_rate;
	}

	public void setCommission_rate(float commission_rate) {
		this.commission_rate = commission_rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
