package cn.cebest.framework.conf;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import com.jfinal.template.ext.spring.JFinalViewResolver;
import com.jfinal.template.source.ClassPathSourceFactory;

/**
 *  模板引擎配置
  * @author maming  
  * @date 2018年8月28日
 */

@Configuration
@ConditionalOnProperty(prefix="gc.template", value="enable", matchIfMissing = true)
public class TemplateConfig {
	
	//  模板位置
	@Value("${gc.template.location}")
	private String location;
	
	/**
	 * 要想使用@Value 用${}占位符注入属性，这个bean是必须的，
	 * 这个就是占位bean,另一种方式是不用value直接用Envirment变量直接getProperty('key')
	 * @return
	 */
	@Bean 
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	

	@Bean
	  public JFinalViewResolver getJFinalViewResolver() {
	    JFinalViewResolver jfr = new JFinalViewResolver();
	    // 设置热启动
	    jfr.setDevMode(true);
	    jfr.setSourceFactory(new ClassPathSourceFactory());
	    // 模板位置
	    if(StringUtils.isNotEmpty(location)){
	    	 JFinalViewResolver.engine.setBaseTemplatePath(location);
	    } else {
	    	 JFinalViewResolver.engine.setBaseTemplatePath("/templates/");
	    }
	    jfr.setSessionInView(true);
	    jfr.setSuffix(".html");
	    jfr.setContentType("text/html;charset=UTF-8");
	    jfr.setOrder(0);
	    return jfr;
	  }
}
