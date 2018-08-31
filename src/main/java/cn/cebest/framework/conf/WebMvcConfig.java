package cn.cebest.framework.conf;

import java.util.Map;
import java.util.Set;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import lombok.extern.slf4j.Slf4j;


/**
 *  webmvc配置
  * @author maming  
  * @date 2018年8月30日
 */

@Slf4j
@Configuration
@ConditionalOnProperty(prefix="gc.webmvc", value="enable", matchIfMissing = true)
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 存放访问的url及要跳转的视图
	 */
	@Value("#{${gc.webmvc.url2views:null}}")
	private Map<String,String> url2views;
	
	/**
	 * 文件上传最大限制
	 */
	@Value("${gc.webmvc.file.maxUploadSize:10 * 1024 * 1024}")
	private String maxUploadSize;

	
	
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
	
	
	/**
	 * 文件上传相关配置
	 * @return
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		// 默认允许最大上传10M
		 ScriptEngineManager manager = new ScriptEngineManager();
		 ScriptEngine se = manager.getEngineByName("js");
		 try {
			Double  maxSize = (Double) se.eval(maxUploadSize);
			multipartResolver.setMaxUploadSize(maxSize.longValue());
		} catch (ScriptException e) {
			log.error("执行表达式异常", e);
		}
		return multipartResolver;
	}
	
	
	
}
