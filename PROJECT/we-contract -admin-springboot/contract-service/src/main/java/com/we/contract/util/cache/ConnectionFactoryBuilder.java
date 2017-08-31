package com.we.contract.util.cache;

import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author lichengjun
 * 
 */
public class ConnectionFactoryBuilder {

    private RedisClientConfig redisClientConfig = new RedisClientConfig();

    public RedisClientConfig getRedisClientConfig() {
        return redisClientConfig;
    }

    public void setTimeout(int timeout) {
        this.redisClientConfig.setTimeout(timeout);
    }

    public int getTimeout() {
        return this.redisClientConfig.getTimeout();
    }

    public void setMaxTotal(int maxTotal) {
        this.redisClientConfig.setMaxTotal(maxTotal);
    }

    public void setMaxIdle(int maxIdle) {
        this.redisClientConfig.setMaxIdle(maxIdle);
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.redisClientConfig.setMaxWaitMillis(maxWaitMillis);
    }

    public void setTestOnBorrow(boolean flag) {
        this.redisClientConfig.setTestOnBorrow(flag);
    }

    public String getMasterConfString() {
        return redisClientConfig.getMasterConfString();
    }

    public void setMasterConfString(String masterConfString) {
        redisClientConfig.setMasterConfString(masterConfString);
    }

    public JedisPoolConfig getJedisPoolConfig() {
        return redisClientConfig.getJedisPoolConfig();
    }
}
