package com.jim.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 刘军
 * @version ${VERSION}
 * @project springboot-data-redis
 * @create 2018/8/10
 */

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setUsePool(true);
        factory.setHostName("localhost");
        factory.setPort(6379);
        factory.setPassword("ge*u0Oj9X");
        factory.setTimeout(2000);
        return factory;
    }

    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String , Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
