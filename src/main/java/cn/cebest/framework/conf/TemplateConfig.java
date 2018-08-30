package cn.cebest.framework.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
	

	@Bean
	  public JFinalViewResolver getJFinalViewResolver() {
	    JFinalViewResolver jfr = new JFinalViewResolver();
	    // 设置热启动
	    jfr.setDevMode(true);
	    jfr.setSourceFactory(new ClassPathSourceFactory());
	    // 模板位置
	    JFinalViewResolver.engine.setBaseTemplatePath("/templates/");
	    jfr.setSessionInView(true);
	    jfr.setSuffix(".html");
	    jfr.setContentType("text/html;charset=UTF-8");
	    jfr.setOrder(0);
	    return jfr;
	  }
}
