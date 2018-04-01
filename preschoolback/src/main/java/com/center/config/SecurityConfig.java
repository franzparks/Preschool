/**
 * 
 */
package com.center.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import com.center.service.UserSecurityService;

/**
 * @author francisphiri
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return SecurityUtility.passwordEncoder();
	}

	private static final String[] PUBLIC_MATCHERS = {
			"/css/**",
			"/static/**",
			"/public/**",
			"/js/**",
			"/image/**",
			"/school/**",
			"/reviews/**",
			"/user/**"
			//"/token",
			//"/checkSession"	
			
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable()
		.httpBasic().and()
		.authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS).permitAll()
		//.antMatchers("/api/**").hasRole("USER")
		.anyRequest().authenticated();
		
		http.headers().frameOptions().sameOrigin();
	}
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().and()
		.formLogin().and()
        .httpBasic().disable()
	    .authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();
		
		http.authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS)
		.permitAll()
        //.antMatchers("/api/**").hasRole("USER")
        .anyRequest().authenticated() 
        .and().formLogin().disable();
        //.csrf().disable().cors().disable();
         http.headers().frameOptions().sameOrigin();
	}*/
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}
	
}
