package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = { "com.demo." })
@EnableWebMvc
public class AppConfig {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver iv = new InternalResourceViewResolver();
		iv.setPrefix("/WEB-INF/jsp/");
		iv.setSuffix(".jsp");
		return iv;
	}
}
