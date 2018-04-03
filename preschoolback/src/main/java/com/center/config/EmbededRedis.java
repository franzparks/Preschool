/**
 * 
 */
package com.center.config;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import redis.embedded.RedisServer;
import redis.embedded.RedisServerBuilder;

/**
 * @author francisphiri
 *
 */
@Component
public class EmbededRedis {
	
	@Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    @PostConstruct
    public void startRedis() throws IOException {
        redisServer = new RedisServerBuilder().setting("maxheap 512Mb").port(6370).build();
        //new RedisServer(redisPort);
        //redisServer.start();
    }

    @PreDestroy
    public void stopRedis() {
        redisServer.stop();
    }
}
