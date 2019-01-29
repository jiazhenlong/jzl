package com.shop.dao.es;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

public abstract class BaseEsDao<T> {
	private static final Logger log = LoggerFactory.getLogger(BaseEsDao.class);

	private String index;
	private String type;
	private Class<T> clazz;

	@Autowired
	public RestHighLevelClient restHighClient;

	public BaseEsDao(String index, String type, Class<T> clazz) {
		this.index = index;
		this.type = type;
		this.clazz = clazz;
	}

	public boolean index(String id, T doc) {
		return indexDoc(index, type, id, doc);
	}

	public T get(String id) {
		return getDoc(index, type, id, clazz);
	}

	public boolean delete(String id) {
		return deleteDoc(index, type, id);
	}

	public List<T> searchAll(int from, int size) {
		return searchAll(index, from, size, clazz);
	}

	public List<T> searchByField(String field, String value, int from, int size) {
		return searchByField(index, field, value, from, size, clazz);
	}
	
	public List<T> search(QueryBuilder queryBuilder, int from, int size) {
		return search(index, queryBuilder, from, size, clazz);
	}

	public <S> List<S> searchAll(String index, int from, int size, Class<S> clazz) {
		return search(index, QueryBuilders.matchAllQuery(), from, size, clazz);
	}

	public <S> List<S> searchByField(String index, String field, String value, int from, int size,
			Class<S> clazz) {
		MatchQueryBuilder matchQuery = QueryBuilders.matchQuery(field, value);
		return search(index, matchQuery, from, size, clazz);
	}

	public <S> List<S> search(String index, QueryBuilder queryBuilder, int from, int size, Class<S> clazz) {
		SearchRequest req = new SearchRequest(index);
		SearchSourceBuilder ssb = new SearchSourceBuilder();
		ssb.query(queryBuilder);
		ssb.from(from);
		ssb.size(size);
		req.source(ssb);
		SearchResponse resp = null;
		try {
			System.out.println(req);
			resp = restHighClient.search(req);
			SearchHits hits = resp.getHits();
			if (hits == null || hits.totalHits < 1) {
				return null;
			}
			Gson gson = new Gson();
			List<S> list = new ArrayList<>();
			for (SearchHit hit : hits) {
				String source = hit.getSourceAsString();
				S doc = gson.fromJson(source, clazz);
				list.add(doc);
			}
			return list;
		} catch (IOException e) {
			log.error("searchAll失败：req-{}, resp-{}, error-{}", req, resp, e);
		}
		return null;
	}

	public boolean indexDoc(String index, String type, String id, Object source) {
		IndexRequest req = new IndexRequest(index, type);
		IndexResponse resp = null;
		req.id(id);
		req.source(new Gson().toJson(source), XContentType.JSON);
		try {
			resp = restHighClient.index(req);
			return true;
		} catch (IOException e) {
			log.error("索引失败：req-{}, resp-{}, error-{}", req, resp, e);
		}
		return false;
	}

	public <S> S getDoc(String index, String type, String id, Class<S> clazz) {
		GetRequest req = new GetRequest(index, type, id);
		GetResponse resp = null;
		try {
			resp = restHighClient.get(req);
			String sourceStr = resp.getSourceAsString();
			S obj = new Gson().fromJson(sourceStr, clazz);
			return obj;
		} catch (IOException e) {
			log.error("获取失败：req-{}, resp-{}, error-{}", req, resp, e);
		}
		return null;
	}

	/**
	 * 
	 * @param index
	 * @param type
	 * @param id
	 * @return
	 */
	public boolean deleteDoc(String index, String type, String id) {
		DeleteRequest req = new DeleteRequest(index, type, id);
		DeleteResponse resp = null;
		try {
			resp = restHighClient.delete(req);
			return true;
		} catch (IOException e) {
			log.error("删除失败：req-{}, resp-{}, error-{}", req, resp, e);
		}
		return false;
	}
}
