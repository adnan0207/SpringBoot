package com.visilean.springboot.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	// since we have defined the users here spring boot will not use the user/pass from the application.properties file

//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//
//		UserDetails harsh = User.builder()
//				.username("harsh")
//				.password("{noop}test123")
//				.roles("EMPLOYEE")
//				.build();
//
//		UserDetails abhay = User.builder()
//				.username("abhay")
//				.password("{noop}test123")
//				.roles("EMPLOYEE", "MANAGER")
//				.build();
//
//		UserDetails adnan = User.builder()
//				.username("adnan")
//				.password("{noop}test123")
//				.roles("EMPLOYEE", "MANAGER", "ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(harsh, abhay, adnan);
//	}
	
	// add support for JDBC ......... no more hardcoded users
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {		//  Inject data source Auto-configured by Spring Boot
		return new JdbcUserDetailsManager(dataSource);			
		// JdbcUserDetailsManager -> Tell Spring Security to use JDBC authentication with our data source
		// dataSource -> no longer hard coding users
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer -> 
			configurer
				.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
				
		);
		
		// use HTTP basic authentication
		
		http.httpBasic(Customizer.withDefaults());
		
		// disable cross site request forgery (CSRF)
		// in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
		
	}
	
}


// db script

//USE `employee_directory`;
//
//DROP TABLE IF EXISTS `authorities`;
//DROP TABLE IF EXISTS `users`;
//
//--
//-- Table structure for table `users`
//--
//
//CREATE TABLE `users` (
//  `username` varchar(50) NOT NULL,
//  `password` varchar(50) NOT NULL,
//  `enabled` tinyint NOT NULL,
//  PRIMARY KEY (`username`)
//) ENGINE=InnoDB DEFAULT CHARSET=latin1;
//
//--
//-- Inserting data for table `users`
//--
//
//INSERT INTO `users` 
//VALUES 
//('harsh','{noop}test123',1),
//('abhay','{noop}test123',1),
//('adnan','{noop}test123',1);
//
//
//--
//-- Table structure for table `authorities`
//--
//
//CREATE TABLE `authorities` (
//  `username` varchar(50) NOT NULL,
//  `authority` varchar(50) NOT NULL,
//  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
//  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
//) ENGINE=InnoDB DEFAULT CHARSET=latin1;
//
//--
//-- Inserting data for table `authorities`
//--
//
//INSERT INTO `authorities` 
//VALUES 
//('harsh','ROLE_EMPLOYEE'),
//('abhay','ROLE_EMPLOYEE'),
//('abhay','ROLE_MANAGER'),
//('adnan','ROLE_EMPLOYEE'),
//('adnan','ROLE_MANAGER'),
//('adnan','ROLE_ADMIN');
