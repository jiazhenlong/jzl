package com.shop.service;

import java.util.List;

import com.shop.dao.es.doc.MerchantShopEsDoc;

public interface MerchantShopEsService {
	
	/**
	 * 增加门店
	 * @param doc
	 * @return
	 */
	boolean indexShop(MerchantShopEsDoc doc);
	
	/**
	 * 删除门店
	 * @param id
	 * @return
	 */
	boolean deleteShop(String id);

	/**
	 * 搜索附近的门店
	 * @param lon 经度
	 * @param lat 纬度
	 * @param distance 
	 */
	List<MerchantShopEsDoc> nearbyShops(double lon, double lat, double distance);

}
