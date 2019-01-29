package com.shop.service.es;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.dao.es.MerchantShopEsDao;
import com.shop.dao.es.doc.MerchantShopEsDoc;
import com.shop.service.MerchantShopEsService;

@Component
public class MerchantShopEsServiceImpl implements MerchantShopEsService{
	
	@Autowired
	private MerchantShopEsDao merchantShopsEsDao;
	
	@Override
	public List<MerchantShopEsDoc> nearbyShops(double lon, double lat, double distance) {
		
		
		return merchantShopsEsDao.nearbyShops(lat, lon, distance);
	}

	@Override
	public boolean indexShop(MerchantShopEsDoc doc) {
		return merchantShopsEsDao.index(doc.getShop_id().toString(), doc);
	}

	@Override
	public boolean deleteShop(String id) {
		return merchantShopsEsDao.delete(id);
	}

}