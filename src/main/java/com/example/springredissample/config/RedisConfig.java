package com.example.springredissample.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.stereotype.Component;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

@Component
//@ConditionalOnProperty("redis")
public class RedisConfig {
    private String host = "localhost";
    private int port = 6379;
    private String password = "password";
    private int connectionTimeout = 2000;
    private int readTimeout = 2000;
    private DefaultJedisClientConfig.Builder configBuilder = DefaultJedisClientConfig.builder();

    public HostAndPort hostAndPort() {
        return new HostAndPort(this.host, this.port);
    }

    /**
     * クライアントの設定を返す.
     */
    public DefaultJedisClientConfig clientConfig() {
        return this.configBuilder
                .password(this.password)
                .connectionTimeoutMillis(this.connectionTimeout)
                .socketTimeoutMillis(this.readTimeout)
                .build();
    }

    /**
     * コネクションプールの設定を返す.
     */
    public GenericObjectPoolConfig<Jedis> poolConfig() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        // poolConfig.setMaxIdle(10);
        // poolConfig.setMaxWait(Duration.ofMillis(1000L));
        // poolConfig.setMaxTotal(1);
        return poolConfig;
    }

}
