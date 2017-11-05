package com.collab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.collab")
public class WebResolver {

	
	 @Bean
	 public InternalResourceViewResolver getViewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/");
	        viewResolver.setSuffix(".html");
	        return viewResolver;
	    }
	 
	 @Bean(name = "multipartResolver")
		public CommonsMultipartResolver getCommonsMultipartResolver() {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
			multipartResolver.setMaxUploadSize(10240000); 
			return multipartResolver;
		}
	     
}
