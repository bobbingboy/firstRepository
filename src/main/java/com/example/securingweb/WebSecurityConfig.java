package com.example.securingweb;

import javax.servlet.annotation.WebServlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/tests", "/home").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login_")
			.permitAll()
			.and()
		.logout()
			.permitAll();
		//this method define which URL paths should be secured and which is not
	}
	
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user =
				 User.withDefaultPasswordEncoder()
					.username("user")
					.password("password")
					.roles("USER")
					.build();

			return new InMemoryUserDetailsManager(user);
	}

	
	
}








