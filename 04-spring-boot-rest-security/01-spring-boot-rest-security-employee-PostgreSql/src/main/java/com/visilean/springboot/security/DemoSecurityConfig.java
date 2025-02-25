package com.visilean.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer -> 
			configurer
				.requestMatchers(HttpMethod.GET, "api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN")
				
		);
		
		// use HTTP basic authentication
		
		http.httpBasic(Customizer.withDefaults());
		
		// disable cross site request forgery (CSRF)
		// in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
		
	}
	
}
