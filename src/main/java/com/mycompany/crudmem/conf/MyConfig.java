package com.mycompany.crudmem.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/***
 * @author Leonid Ivanov
 */
@Configuration
@ComponentScan("com.mycompany")
@EnableWebMvc
public class MyConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

}
