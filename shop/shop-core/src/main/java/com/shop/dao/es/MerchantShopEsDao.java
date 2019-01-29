package com.shop.dao.es;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.shop.dao.es.doc.MerchantShopEsDoc;

@Component
public class MerchantShopEsDao extends BaseEsDao<MerchantShopEsDoc>{
	private static final Logger log = LoggerFactory.getLogger(MerchantShopEsDao.class);
	public static final String INDEX_NAME = "merchant-shops";
	public static final String TYPE_NAME = "doc";
	
	public MerchantShopEsDao() {
		super(INDEX_NAME, TYPE_NAME, MerchantShopEsDoc.class);
	}
	
	public List<MerchantShopEsDoc> nearbyShops(double lat, double lon, double distance) {
		SearchRequest req = new SearchRequest(INDEX_NAME);
		SearchSourceBuilder ssb = new SearchSourceBuilder();
		GeoDistanceQueryBuilder geoDistanceQueryBuilder = new GeoDistanceQueryBuilder("location");
		geoDistanceQueryBuilder.point(lat, lon).distance(distance,
				DistanceUnit.KILOMETERS);
		ssb.query(geoDistanceQueryBuilder);
		req.source(ssb);

		SearchResponse resp = null;
		try {
			resp = restHighClient.search(req);
		} catch (IOException e) {
			log.error("查询附近门店失败：req-{}, resp-{}, error-{}", req, resp, e);
			e.printStackTrace();
		}

		SearchHits hits = resp.getHits();
		List<MerchantShopEsDoc> docs = new ArrayList<>();
		for (SearchHit hit : hits) {
			String json = hit.getSourceAsString();
			MerchantShopEsDoc doc = new Gson().fromJson(json, MerchantShopEsDoc.class);
			docs.add(doc);
		}
		return docs;
	}
	
}
