package com.visilean.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
	
	// since we have defined the users here spring boot will not use the user/pass from the application.properties file

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails harsh = User.builder()
				.username("harsh")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();

		UserDetails abhay = User.builder()
				.username("abhay")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails adnan = User.builder()
				.username("adnan")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(harsh, abhay, adnan);
	}
}
