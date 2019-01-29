package com.shop.config;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ESConfig implements FactoryBean<RestHighLevelClient>, InitializingBean, DisposableBean {
	private static final Logger log = LoggerFactory.getLogger(ESConfig.class);

    @Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusterNodes;

	private RestHighLevelClient restHighLevelClient;

	/**
	 * @Description: 控制Bean的实例化过程
	 * @author shiyj
	 */
	@Override
	public RestHighLevelClient getObject() throws Exception {
		return restHighLevelClient;
	}

	/**
	 * @Description: 获取接口返回的实例的class
	 * @author shiyj
	 */
	@Override
	public Class<?> getObjectType() {
		return RestHighLevelClient.class;
	}

	@Override
	public void destroy() throws Exception {
		try {
			if (restHighLevelClient != null) {
				restHighLevelClient.close();
			}
		} catch (final Exception e) {
			log.error("Error closing ElasticSearch client: ", e);
		}
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		restHighLevelClient = buildClient();
	}

	private RestHighLevelClient buildClient() {
		String[] nodes = clusterNodes.split(",");
		HttpHost[] hosts = new HttpHost[nodes.length];
		for (int i = 0, j = nodes.length; i < j; i++) {
			String hostName = nodes[i].split(":")[0];
			String port = nodes[i].split(":")[1];
			hosts[i] = new HttpHost(hostName, Integer.valueOf(port), "http");
		}
		try {
			restHighLevelClient = new RestHighLevelClient(
					RestClient.builder(hosts).setHttpClientConfigCallback(callback -> {
						callback.disableAuthCaching();
						return callback.setKeepAliveStrategy((response, context) -> {
							Args.notNull(response, "HTTP response");
							final HeaderElementIterator it = new BasicHeaderElementIterator(
									response.headerIterator(HTTP.CONN_KEEP_ALIVE));
							while (it.hasNext()) {
								final HeaderElement he = it.nextElement();
								final String param = he.getName();
								final String value = he.getValue();
								if (value != null && param.equalsIgnoreCase("timeout")) {
									try {
										return Long.parseLong(value) * 1000;
									} catch (final NumberFormatException ignore) {
									}
								}
							}
							return 10 * 1000;
						});
					}));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return restHighLevelClient;
	}

}
