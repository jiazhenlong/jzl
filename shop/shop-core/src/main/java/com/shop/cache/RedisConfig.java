package com.shop.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**  
*
* @Title:  RedisConfig.java   
* @Package com.shop.cache   
* @Description:    TODO(redis配置类)   
* @author: jiazhenlong     
* @date:   2018年5月29日 上午9:56:11   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {


  @Bean
  public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
    CacheManager cacheManager = new RedisCacheManager(redisTemplate);
    return cacheManager;
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
    redisTemplate.setConnectionFactory(factory);
    
    //设置序列化工具
    setSerializer(redisTemplate);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

  private void setSerializer(RedisTemplate<String, Object> template) {
    @SuppressWarnings("rawtypes")
    RedisSerializer stringSerializer = new StringRedisSerializer();
    
    template.setValueSerializer(stringSerializer);
    template.setKeySerializer(stringSerializer);
    template.setHashKeySerializer(stringSerializer);
    template.setHashValueSerializer(stringSerializer);
  }
}
