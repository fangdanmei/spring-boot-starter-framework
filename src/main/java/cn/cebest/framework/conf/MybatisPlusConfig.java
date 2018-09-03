package cn.cebest.framework.conf;

import java.util.Properties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.github.pagehelper.PageHelper;


/**
 *  mybatis-plus配置
  * @author maming  
  * @date 2018年8月28日
 */
@Configuration
@ConditionalOnProperty(prefix="gc.mybatis", value="enable", matchIfMissing = true)
public class MybatisPlusConfig {

	/**
	 * 分页插件
	 * @return
	 */
	@Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

	
	/**
	 * 注册MyBatis分页插件PageHelper
	 */
	@Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("dialect", "mysql");
        pageHelper.setProperties(p);
        return pageHelper;
	}
}
