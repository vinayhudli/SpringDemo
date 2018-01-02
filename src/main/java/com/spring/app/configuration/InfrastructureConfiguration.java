package com.spring.app.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class InfrastructureConfiguration {
	
	@Bean
	public DataSource dataSource(){
		return new DriverManagerDataSource() ;
	}
}
