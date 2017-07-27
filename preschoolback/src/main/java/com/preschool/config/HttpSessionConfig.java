/**
 * 
 */
package com.preschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author francisphiri
 *
 */
@EnableRedisHttpSession
public class HttpSessionConfig {
	@Bean
	public LettuceConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory("http://eyas-redis.ajkq9r.ng.0001.usw1.cache.amazonaws.com",6379);
		//return new LettuceConnectionFactory();
	}
}
