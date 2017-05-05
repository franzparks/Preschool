/**
 * 
 */
package com.preschool.config;

import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author francisphiri
 *
 */
public class SecurityUtility {
	private static final String SALT = "salt"; //Salt should be protected carefully	
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
}
