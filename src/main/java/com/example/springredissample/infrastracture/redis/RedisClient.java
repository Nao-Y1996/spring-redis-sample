package com.example.springredissample.infrastracture.redis;

import com.example.springredissample.config.RedisConfig;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;


@Component
public class RedisClient {

    private final JedisPool jedisPool;

    public RedisClient(RedisConfig redisConfig) {
        this.jedisPool = new JedisPool(redisConfig.hostAndPort(),redisConfig.clientConfig());
        // this.jedisPool = new JedisPool(redisConfig.poolConfig(), redisConfig.hostAndPort(), redisConfig.clientConfig());
    }

    public Jedis getResource() {
        return this.jedisPool.getResource();
    }
}
