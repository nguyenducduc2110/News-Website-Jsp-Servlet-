
package com.webspringmvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

@EnableJpaRepositories(basePackages = {"com.webspringmvc.repository", "com.webspringmvc.auth.repositoty"})
@EnableTransactionManagement

public class JPAConfig {
	
     DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:
        dataSource.setUsername("root");
        dataSource.setPassword("21102004");
        return dataSource;
    }
	
	
     

     @Bean
	 public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(dataSource());
	        em.setPersistenceUnitName("persistence-data");
	        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        em.setJpaProperties(additionalProperties());
	        return em;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
	Properties additionalProperties() {
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return properties;
	}
	
}
