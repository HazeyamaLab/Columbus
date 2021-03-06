package com.example;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import com.example.service.LoginUserDetails;
import com.example.service.LoginUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired LoginUserDetailsService userDetailsService;
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/webjsrs/**","/css/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
				.antMatchers("/loginForm").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginProcessingUrl("/login")
				.loginPage("/loginForm")
				.failureUrl("/loginForm?error")
				.defaultSuccessUrl("/upload",true)
				.usernameParameter("id")
				.passwordParameter("password")
			.and()
			.logout()
				.logoutSuccessUrl("/loginForm")
			.and()
			.rememberMe()
			.key("mallow")
			.rememberMeParameter("remember-me")
			.rememberMeCookieName("remember-me")
			.userDetailsService(userDetailsService);
			
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new Pbkdf2PasswordEncoder();
	}
}
*/