package com.we.p2p.util.cache;

import redis.clients.jedis.JedisPoolConfig;


/**
 * 
 * @author lichengjun
 * 
 */
public class RedisClientConfig {

    private JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

    private int timeout = 2000;

    private String masterConfString = null;

    public void setMaxTotal(int maxTotal) {
        this.jedisPoolConfig.setMaxTotal(maxTotal);
    }

    public void setMaxIdle(int maxIdle) {
        this.jedisPoolConfig.setMaxIdle(maxIdle);
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.jedisPoolConfig.setTestOnBorrow(testOnBorrow);
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getMasterConfString() {
        return masterConfString;
    }

    public void setMasterConfString(String masterConfString) {
        this.masterConfString = masterConfString;
    }

    public JedisPoolConfig getJedisPoolConfig() {
        return jedisPoolConfig;
    }

}
