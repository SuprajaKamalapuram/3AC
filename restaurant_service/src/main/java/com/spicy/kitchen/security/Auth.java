package com.spicy.kitchen.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Auth extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
	    .withUser("user").password("{noop}password").roles("USER")
        .and()
        .withUser("admin").password("{noop}password").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
        //HTTP Basic authentication
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/api/restaurant/id").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/api/restaurant").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/api/restaurant/id").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE,"/api/restaurant/id").hasRole("ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable();
		http.headers().frameOptions().disable ();
	}
}