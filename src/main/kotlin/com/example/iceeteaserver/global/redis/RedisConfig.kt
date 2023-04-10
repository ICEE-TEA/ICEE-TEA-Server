package com.example.iceeteaserver.global.redis

import com.example.iceeteaserver.global.redis.properties.RedisProperties
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations

@Configuration
open class RedisConfig(
    private val redisProperties: RedisProperties,
) {
    @Bean
    open fun redisConnectionFactory(): RedisConnectionFactory =
        LettuceConnectionFactory(redisProperties.host, redisProperties.port)

    @Bean
    open fun redisTemplate(): RedisTemplate<String, Any> {
        val redisTemplate: RedisTemplate<String, Any> = RedisTemplate()
        redisTemplate.setConnectionFactory(redisConnectionFactory())
        return redisTemplate
    }

    @Bean
    open fun zSetOperation(): ZSetOperations<String, Any> =
        redisTemplate().opsForZSet()
}