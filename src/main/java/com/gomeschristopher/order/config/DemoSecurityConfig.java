package com.gomeschristopher.order.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	/**/
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username = ?");
		
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(""
				+ "SELECT username, role.name FROM role JOIN users_roles ON users_roles.role_id = role.id JOIN user ON user.id = users_roles.user_id WHERE username = ?"
				);
		
		
		return jdbcUserDetailsManager;
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer ->
		configurer
				.requestMatchers(HttpMethod.GET, "/users").hasRole("USER")
				.requestMatchers(HttpMethod.GET, "/user/**").hasRole("USER")
				.requestMatchers(HttpMethod.POST, "/users").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/users/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
		);
		
		http.httpBasic(Customizer.withDefaults());
		
		http.csrf(crsf -> crsf.disable());
		
		return http.build();
	}
	
	/*
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails john = User.builder()
				.username("john")
				.password("{noop}123")
				.roles("USER")
				.build();
		
		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}123")
				.roles("USER", "MANAGER")
				.build();
		
		UserDetails susan = User.builder()
				.username("susan")
				.password("{noop}123")
				.roles("USER", "MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(john, mary, susan);
	}
	*/
}
