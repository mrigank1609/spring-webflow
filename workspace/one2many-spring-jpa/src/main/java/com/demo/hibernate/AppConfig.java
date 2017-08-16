package com.demo.hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.demo." })
@EnableTransactionManagement
public class AppConfig {
	@Bean
	public DriverManagerDataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/hibernate");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(ds());
		emf.setPackagesToScan("com.demo.hibernate");

		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();

		va.setDatabase(Database.MYSQL);
		va.setShowSql(true);
		emf.setJpaVendorAdapter(va);
		return emf;
	}

	@Bean
	public JpaTransactionManager txManager() {
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(emf().getObject());
		return txm;
	}

}
