package com.mycompany.crudmem.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mycompany.crudmem.model.Client;

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

	@Bean
	public List<Client> dataList() {
		List<Client> list = new ArrayList<Client>();
		return list;
	}

}
