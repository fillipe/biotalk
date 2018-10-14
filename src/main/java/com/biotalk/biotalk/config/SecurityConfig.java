package com.biotalk.biotalk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImp userDetailsService;
	
	@Autowired
	private LoginSuccessHandler loginSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/anonymous/**").permitAll()
			.antMatchers("/css/**", "/images/**", "/js/**").permitAll()
			.antMatchers("/api/user/verifyByCpf/**").permitAll()
//			.antMatchers("/auth/**").hasAnyRole()
			.antMatchers("/comum/**").hasRole("COMUM")
			.antMatchers("/espec/**").hasRole("ESPEC")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login").successHandler(loginSuccessHandler)
			.permitAll()
			.and()
		.logout()
			.logoutSuccessUrl("/login")
			.and()
		.exceptionHandling() //exception handling configuration
			.accessDeniedPage("/app/error")
			.and()
		.csrf()
			.disable();
	}
	

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/images**");
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("12345678"));
	}
	
}
