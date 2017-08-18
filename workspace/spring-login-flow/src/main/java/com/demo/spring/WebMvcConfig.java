package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.demo.spring" })
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	WebFlowConfig flowConfig;

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/login/");
		vr.setSuffix(".jsp");
		return vr;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	@Bean
	public FlowHandlerMapping FlowHandlerMapping() {
		FlowHandlerMapping mapping = new FlowHandlerMapping();
		mapping.setOrder(-1);
		mapping.setFlowRegistry(flowConfig.flowRegistry());
		return mapping;
	}

	@Bean
	public FlowHandlerAdapter flowHandlerAdapter() {
		FlowHandlerAdapter ad = new FlowHandlerAdapter();
		ad.setFlowExecutor(flowConfig.flowExecutor());
		ad.setSaveOutputToFlashScopeOnRedirect(true);
		return ad;
	}
}
