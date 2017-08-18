package com.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.demo.spring" })
public class WebConfig {

	/*
	 * @Bean public InternalResourceViewResolver viewResolver() {
	 * InternalResourceViewResolver vr = new InternalResourceViewResolver();
	 * vr.setPrefix("/WEB-INF/pages/"); vr.setSuffix(".jsp"); return vr; }
	 */
	@Bean
	public ResourceBundleViewResolver viewResolver() {
		ResourceBundleViewResolver vr = new ResourceBundleViewResolver();
		vr.setBasename("views");
		return vr;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
}
