package cn.cebest.framework.conf;

import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 *  webmvc配置
  * @author maming  
  * @date 2018年8月30日
 */
@Configuration
@ConditionalOnProperty(prefix="gc.webmvc", value="enable", matchIfMissing = true)
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	@Value("#{${gc.webmvc.url2views:null}}")
	private Map<String,String> url2views;

	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	/**
	 * 无逻辑视图跳转
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		if (url2views != null) {
			Set<String> keys = url2views.keySet();
			for (String key : keys) {
				String value = url2views.get(key);
				registry.addViewController("/" + key).setViewName("/" + value);
			}
		}
	}
	
	
	
}
