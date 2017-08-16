package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import com.demo.spring.dao.AppConfig;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.demo." })
public class WebConfig {

	/*
	 * @Bean public InternalResourceViewResolver internalResourceViewResolver()
	 * { InternalResourceViewResolver resolver = new
	 * InternalResourceViewResolver(); resolver.setPrefix("/WEB-INF/pages/");
	 * resolver.setSuffix(".jsp"); return resolver; }
	 */

	@Bean
	public ResourceBundleViewResolver resolver() {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setBasename("views");
		return resolver;
	}

}
