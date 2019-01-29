package com.shop.dao.es;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.shop.dao.es.doc.AdsEsDoc;

@Component
public class AdsEsDao extends BaseEsDao<AdsEsDoc>{
	private static final Logger log = LoggerFactory.getLogger(AdsEsDao.class);
	public static final String INDEX_NAME = "ads";
	public static final String TYPE_NAME = "doc";
	
	public AdsEsDao() {
		super(INDEX_NAME, TYPE_NAME, AdsEsDoc.class);
	}
	
}
