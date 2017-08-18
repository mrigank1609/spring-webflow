package com.demo.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.persistence.JpaFlowExecutionListener;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

	@Autowired
	WebMvcConfig webConfig;
	@Autowired
	AppConfig dbConfig;

	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(flowRegistry())
				.addFlowExecutionListener(jpaFlowExecutionListener())
				.build();
	}

	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder().addFlowLocation("/WEB-INF/login/login.xml")
				.setFlowBuilderServices(flowBuilderServices())
				.build();
	}

	@Bean
	public FlowBuilderServices flowBuilderServices() {
		return getFlowBuilderServicesBuilder().setViewFactoryCreator(viewFactoryCreator()).setDevelopmentMode(true)
				.build();
	}

	@Bean
	public MvcViewFactoryCreator viewFactoryCreator() {
		MvcViewFactoryCreator vc = new MvcViewFactoryCreator();
		vc.setViewResolvers(Arrays.<ViewResolver>asList(webConfig.viewResolver()));
		vc.setUseSpringBeanBinding(true);
		return vc;
	}

	@Bean
	public JpaFlowExecutionListener jpaFlowExecutionListener() {
		JpaFlowExecutionListener jel = new JpaFlowExecutionListener(dbConfig.entityManagarFactory().getObject(),
				dbConfig.transactionManager());
		return jel;
	}
}
