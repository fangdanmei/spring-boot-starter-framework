package cn.cebest.framework.cache.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * redis配置参数
  * @author maming  
  * @date 2018年8月28日
 */
@Setter
@Getter
@ConfigurationProperties(prefix="gc.redis")
public class RedisCg {

	private String host;

	private int port;
}
