package cn.cebest.framework.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import cn.cebest.framework.mail.impl.MailServiceImpl;


/**
 *  邮件配置
  * @author maming  
  * @date 2018年8月28日
 */
@Configuration
@ConditionalOnClass(MailService.class)
@ConditionalOnProperty(prefix="gc.mail", value="enable", matchIfMissing = true)
public class MailConfig {

	@Bean
	@ConditionalOnMissingBean(MailService.class)
	public MailService mailService(){
		return new MailServiceImpl();
	}
	
}
