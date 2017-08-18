package com.demo.spring;

import javax.sql.DataSource;

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
@ComponentScan(basePackages = { "com.demo.spring" })
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagarFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.demo.spring.model");

		HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
		hjva.setShowSql(true);
		hjva.setDatabase(Database.MYSQL);

		emf.setJpaVendorAdapter(hjva);
		return emf;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setDataSource(dataSource());
		txm.setEntityManagerFactory(entityManagarFactory().getObject());
		return txm;
	}

}
