package com.we.demo.util;

import com.we.demo.BaseTest;
import com.we.p2p.util.RedisKeyConstant;
import com.we.p2p.util.cache.RedisClientUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huyucheng on 2016/6/2.
 */
public class RedisUtilTest extends BaseTest {

    @Autowired
    private RedisClientUtils redisUtils;

    @Test
    public void testSetData() {
        try {

            String type = redisUtils.type(RedisKeyConstant.FILE_BATCH_NO);
            Long ttl = redisUtils.ttl(RedisKeyConstant.FILE_BATCH_NO);
            System.out.println("------------------------------------- type"+type);
            System.out.println("------------------------------------- ttl"+ttl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
