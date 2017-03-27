package com.jungang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * 인증
		 */
		auth.inMemoryAuthentication()
				.withUser("admin").password("1234").roles("ADMIN")
				.and()
				.withUser("user").password("1234").roles("USER");
//		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * 권한
		 */
		http.csrf().disable()									//보안관련
			.authorizeRequests()
				.antMatchers("/login/**").hasRole("ADMIN")
//				.antMatchers("/register/**").hasRole("ADMIN")
				.antMatchers("/**").permitAll()
			.and()
			.formLogin()
			.permitAll();
		
	}
}
