package com.zhousz.ms.redis;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

@Service
public class RedisPoolFactory {

    @Autowired
    private RedisConfig redisConfig;

    @Bean(name = "JedisPool")
    public JedisPool jedisPoolFactory() {
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
//        genericObjectPoolConfig.setMaxIdle(100);
//        genericObjectPoolConfig.setMaxTotal(500);
//        genericObjectPoolConfig.setMinIdle(10);
        JedisPool jp = new JedisPool(genericObjectPoolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeOut(), redisConfig.getPassword());
        return jp;
    }
}
