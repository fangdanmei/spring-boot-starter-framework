package cn.cebest.framework.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;


/**
 *  mybatis-plus配置
  * @author maming  
  * @date 2018年8月28日
 */
@Configuration
@ConditionalOnProperty(prefix="gc.mybatisplus", value="enable", matchIfMissing = true)
public class MybatisPlusConfig {

	/**
	 * 分页插件
	 * @return
	 */
	@Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
