package com.example.booklet.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@PropertySource("classpath:application.properties")
@EnableRedisRepositories
public class RepositoryConfiguration {
    
    @Value("${spring.redis.host}")
    private String redisHostName;

    @Value("${spring.redis.port}")
    private int redisPort;
    
    @Bean
    RedisConnectionFactory connectionFactory() {
	JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
	jedisConFactory.setHostName(redisHostName);
	jedisConFactory.setPort(redisPort);
	return jedisConFactory;
    }

    @Bean
    RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {

	RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
	template.setConnectionFactory(connectionFactory);

	return template;
    }
}
