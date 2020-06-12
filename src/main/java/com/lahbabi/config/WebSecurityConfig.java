package com.lahbabi.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
 		// enable in memory based authentication with a user named "user" and "admin"
 		.inMemoryAuthentication().
 			withUser("user").password("{noop}password").roles("USER")
 				.and().
 			withUser("admin").password("{noop}password").roles("USER", "ADMIN");
	}
	

}
