package com.evertz.contact.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.evertz.contact.dao.ContactDAO;
import com.evertz.contact.dao.ContactDAOImpl;
import com.evertz.contact.dao.AdminDAO;
import com.evertz.contact.dao.AdminDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.evertz.contact")
public class SpringMvcConfig implements WebMvcConfigurer{
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
		
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public ContactDAO getContactDAO(){
		return new ContactDAOImpl(getDataSource());
	}
	
	@Bean
	public AdminDAO getUserDAO(){
		return new AdminDAOImpl(getDataSource());
	}
}
