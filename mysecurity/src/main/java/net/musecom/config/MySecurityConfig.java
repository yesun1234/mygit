package net.musecom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)

public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
			.withUser("wein")
			.password("$2a$10$9VkBnbYVVCw/nKArz9AKUei4X.moE/q5f48A10kBn1C32EJVBnjbG")
			.roles("ADMIN");
		
		System.out.println("my password is crypt " + bcryptPasswordEncoder.encode("1234"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() 			// �듅�씤�슂泥�  .anyRequest() 紐⑤뱺�슂泥�
		/*
			.antMatchers("/").permitAll() 	// 吏꾩엯 �럹�씠吏� 怨듦컻
			.antMatchers("/hello").permitAll()
			.antMatchers("/bye").permitAll()
			.antMatchers("/member/**").fullyAuthenticated() //member �뤃�뜑�뒗 �씤利�
			*/
			.antMatchers("/member/**").authenticated() //member �뤃�뜑�뒗 �씤利�
			.anyRequest().permitAll()
			.and()
			.formLogin()
			.and()
			.logout();
	}
}
