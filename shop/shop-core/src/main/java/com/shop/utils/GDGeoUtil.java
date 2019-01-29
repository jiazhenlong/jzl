package com.shop.utils;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.common.geo.GeoPoint;

import com.google.gson.Gson;

public class GDGeoUtil {
	/**
	 * 高德应用key(需向高德申请)
	 */
	private static final String GD_KEY = "441c6e6245c510ac94211284513fa3fc";
	/**
	 * 高德地图地址转经纬度接口
	 */
	private static final String GEO_API = "http://restapi.amap.com/v3/geocode/geo?city={0}&address={1}&key={2}";

	/**
	 * 根据城市，位置信息获取经纬度
	 * 
	 * @param city
	 *            为空时在全国范围查找
	 * @param addr
	 * @return null表示获取失败
	 */
	public static GeoPoint getGeoPoint(String city, String addr) {
		city = city == null ? "" : city;
		GDResp resp = getGeoResp(city, addr);
		GeoCode[] geocodes = resp.getGeocodes();
		GeoPoint geoPoint = null;
		if (geocodes != null && geocodes.length == 1 && geocodes[0].getLocation() != null) {
			String[] splits = geocodes[0].getLocation().split(",");
			if (splits.length == 2) {
				geoPoint = new GeoPoint(Float.parseFloat(splits[1]), Float.parseFloat(splits[0]));
			}
		}
		return geoPoint;
	}

	/**
	 * 根据城市，地址获取地理信息
	 * 
	 * @param city
	 * @param addr
	 * @return
	 */
	private static GDResp getGeoResp(String city, String addr) {

		String url = MessageFormat.format(GEO_API, city, addr, GD_KEY);

		GDResp resp = getHttp(url, GDResp.class);
		return resp;
	}

	/**
	 * 请求url，并将json格式的响应体转为T类型返回
	 * 
	 * @param url
	 * @param clazz
	 * @return
	 */
	private static <T> T getHttp(String url, Class<T> clazz) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		try {
			CloseableHttpResponse response = httpclient.execute(httpget);
			String jsonRet = EntityUtils.toString(response.getEntity());
			T obj = new Gson().fromJson(jsonRet, clazz);
			return obj;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	class GDResp {
		/**
		 * 状态值:0 表示请求失败；1 表示请求成功。
		 */
		private Integer status;
		/**
		 * 结果数目
		 */
		private Integer count;
		/**
		 * 状态说明
		 */
		private String info;

		/**
		 * 地理编码信息列表
		 */
		private GeoCode[] geocodes;

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		public GeoCode[] getGeocodes() {
			return geocodes;
		}

		public void setGeocodes(GeoCode[] geocodes) {
			this.geocodes = geocodes;
		}

		@Override
		public String toString() {
			return "GDResp [status=" + status + ", count=" + count + ", info=" + info + ", geocodes="
					+ Arrays.toString(geocodes) + "]";
		}

	}

	/**
	 * 地理编码信息列表
	 */
	public class GeoCode {
		/**
		 * 结构化地址信息:省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码
		 */
		private String formatted_address;
		/**
		 * 省份名
		 */
		private String province;
		/**
		 * 城市编码
		 */
		private String citycode;
		/**
		 * 城市名
		 */
		private String city;
		/**
		 * 所在的区
		 */
		// private String district;
		/**
		 * 所在的乡镇
		 */
		// private String township;
		/**
		 * 街道
		 */
		// private String street;
		/**
		 * 门牌
		 */
		// private String number;
		/**
		 * 区域编码
		 */
		// private String adcode;
		/**
		 * 坐标点(经度，纬度)
		 */
		private String location;
		/**
		 * 匹配级别
		 */
		private String level;

		public String getFormatted_address() {
			return formatted_address;
		}

		public void setFormatted_address(String formatted_address) {
			this.formatted_address = formatted_address;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getCitycode() {
			return citycode;
		}

		public void setCitycode(String citycode) {
			this.citycode = citycode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

		@Override
		public String toString() {
			return "GeoCode [formatted_address=" + formatted_address + ", province=" + province + ", citycode="
					+ citycode + ", city=" + city + ", location=" + location + ", level=" + level + "]";
		}

	}
}
