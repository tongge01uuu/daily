package com.we.p2p.util.cache;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.FactoryBean;

import java.util.List;


public class RedisClientFactoryBean implements FactoryBean<RedisClientUtils> {

    private ConnectionFactoryBuilder connectionFactoryBuilder = new ConnectionFactoryBuilder();

    private List<String> masterConfList = null;

    @Override
    public RedisClientUtils getObject() throws Exception {
        // 检查spring redis server配置
        if (StringUtils.isBlank(connectionFactoryBuilder.getMasterConfString()) && (masterConfList == null || masterConfList.isEmpty())) {
            throw new ExceptionInInitializerError("redisClientUtils all init parameter is empty,please check spring config file!");
        }

        return new RedisClientUtils(connectionFactoryBuilder, masterConfList);
    }

    @Override
    public Class<RedisClientUtils> getObjectType() {
        return RedisClientUtils.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setMasterConfString(String string) {
        this.connectionFactoryBuilder.setMasterConfString(string);
    }

    public void setMaxActive(int maxTotal) {
        this.connectionFactoryBuilder.setMaxTotal(maxTotal);
    }

    public void setMaxIdle(int maxIdle) {
        this.connectionFactoryBuilder.setMaxIdle(maxIdle);
    }

    public void setMaxWait(int maxWait) {
        this.connectionFactoryBuilder.setMaxWaitMillis(maxWait);
    }

    public void setTestOnBorrow(boolean flag) {
        this.connectionFactoryBuilder.setTestOnBorrow(flag);
    }

    public void setTimeout(int timeout) {
        this.connectionFactoryBuilder.setTimeout(timeout);
    }

    public void setMasterConfList(List<String> masterConfList) {
        this.masterConfList = masterConfList;
    }

}
