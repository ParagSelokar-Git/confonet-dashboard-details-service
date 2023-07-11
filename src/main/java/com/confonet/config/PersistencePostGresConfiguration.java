package com.confonet.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { 
		"com.confonet.entity", "com.confonet.repository" }, entityManagerFactoryRef = "postgresEntityManager", transactionManagerRef = "postgresTransactionManager")
@EnableTransactionManagement
public class PersistencePostGresConfiguration {

	@Autowired
	private Environment env;

	public PersistencePostGresConfiguration() {
		super();
	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean postgresEntityManager() {
		String[] packagesArray = "com.backend.model,com.backend.crz.repository".split(",");
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(postgresDataSource());
		em.setPackagesToScan(packagesArray);

		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		final HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
		properties.put("hibernate.dialect", env.getProperty("postgres.hibernate.dialect"));
		properties.put("org.hibernate.envers.audit_table_suffix", "_aud");

		properties.put("hibernate.listeners.envers.autoRegister", true);
		properties.put("hibernate.envers.autoRegisterListeners", true);
		em.setJpaPropertyMap(properties);

		return em;
	}


	@Primary
	@Bean
	public DataSource postgresDataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
			dataSource.setUsername("parivesh_user");
			dataSource.setPassword("admin");
		return dataSource;
	}

	@Primary
	@Bean
	public PlatformTransactionManager postgresTransactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(postgresEntityManager().getObject());
		return transactionManager;
	}
}
