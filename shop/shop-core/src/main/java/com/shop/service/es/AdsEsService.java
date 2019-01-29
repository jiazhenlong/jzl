package com.shop.service.es;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.dao.es.AdsEsDao;
import com.shop.dao.es.doc.AdsEsDoc;

@Component
public class AdsEsService{
	
	@Autowired
	private AdsEsDao adsEsDao;
	
	/**
	 * 添加广告
	 * @param doc
	 * @return
	 */
	public boolean indexAds(AdsEsDoc doc) {
		return adsEsDao.index(doc.getAds_id().toString(), doc);
	}
	
	/**
	 * 删除广告
	 * @param id
	 * @return
	 */
	public boolean deleteAds(String id) {
		return adsEsDao.delete(id);
	}
	
	/**
	 * 查询所有广告
	 * @param from
	 * @param size
	 * @return
	 */
	public List<AdsEsDoc> searchAll(int from, int size){
		return adsEsDao.searchAll(from, size);
	}
	
	/**
	 * 查询所有广告
	 * @param field
	 * @param value
	 * @param from
	 * @param size
	 * @return
	 */
	public List<AdsEsDoc> searchByField(String field, String value, int from, int size){
		return adsEsDao.searchByField(field, value, from, size);
	}
}