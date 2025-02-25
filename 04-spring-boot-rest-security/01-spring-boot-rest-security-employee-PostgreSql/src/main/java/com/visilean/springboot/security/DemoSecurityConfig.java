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
	public UserDetailsManager userDetailsManager(DataSource dataSource) {		

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);		
		
		// defining query to retrieve a  user by username
		
		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
		
		// defining query to retrieve the authorities/roles by username
		
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
		
		return jdbcUserDetailsManager;			
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

//-- Drop tables if they exist
//DROP TABLE IF EXISTS authorities;
//DROP TABLE IF EXISTS users;
//
//-- Table structure for table `users`
//CREATE TABLE users (
//  username VARCHAR(50) NOT NULL,
//  password VARCHAR(50) NOT NULL,
//  enabled SMALLINT NOT NULL,
//  PRIMARY KEY (username)
//);
//
//-- Inserting data for table `users`
//INSERT INTO users (username, password, enabled) VALUES 
//('harsh', '{noop}test123', 1),
//('abhay', '{noop}test123', 1),
//('adnan', '{noop}test123', 1);
//
//-- Table structure for table `authorities`
//CREATE TABLE authorities (
//  username VARCHAR(50) NOT NULL,
//  authority VARCHAR(50) NOT NULL,
//  UNIQUE (username, authority),
//  FOREIGN KEY (username) REFERENCES users (username)
//);
//
//-- Inserting data for table `authorities`
//INSERT INTO authorities (username, authority) VALUES 
//('harsh', 'ROLE_EMPLOYEE'),
//('abhay', 'ROLE_EMPLOYEE'),
//('abhay', 'ROLE_MANAGER'),
//('adnan', 'ROLE_EMPLOYEE'),
//('adnan', 'ROLE_MANAGER'),
//('adnan', 'ROLE_ADMIN');