package cn.cebest.framework.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import cn.cebest.framework.cache.redis.impl.RedisServiceImpl;
import redis.clients.jedis.JedisShardInfo;


/**
 *  redis配置
  * @author maming  
  * @date 2018年8月28日
 */


@Configuration
@EnableConfigurationProperties(RedisCg.class)
@ConditionalOnClass(RedisService.class)
@ConditionalOnProperty(prefix="gc.redis", value="enable", matchIfMissing = true)
public class RedisConfig {

	@Autowired
	private RedisCg redisCg;
	
	@Bean
	@ConditionalOnMissingBean(RedisService.class)
	public RedisService redisService(){
		RedisService redisService = new RedisServiceImpl();
		return redisService;
	}


	@Bean
	public JedisShardInfo jedisShardInfo() {
		JedisShardInfo jedisShardInfo = new JedisShardInfo(redisCg.getHost(), redisCg.getPort());
		return jedisShardInfo;
	}

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory(jedisShardInfo());
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		return new StringRedisTemplate(jedisConnectionFactory());
	}
}
