package com.we.contract.util.cache;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MybatisRedisCache implements Cache {
    private static final Logger log = LoggerFactory.getLogger(MybatisRedisCache.class);
    /**
     * The ReadWriteLock.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("必须传入ID");
        }
//        log.debug("MybatisRedisCache:id=" + id);
        this.id = id;
    }

    /**
     * 1. 获取Jedis实例需要从JedisPool中获取
     * 2. 用完Jedis实例需要还给JedisPool
     * 3. 如果Jedis在使用过程中出错，则也需要还给JedisPool
     */

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getSize() {
        Jedis jedis = null;
        JedisPool jedisPool = null;
        int result = 0;
        boolean borrowOrOprSuccess = true;
        try {
            jedis = CachePool.getInstance().getJedis();
            jedisPool = CachePool.getInstance().getJedisPool();
            result = Integer.valueOf(jedis.dbSize().toString());
        } catch (JedisConnectionException e) {
            borrowOrOprSuccess = false;
            if (jedis != null)
                jedisPool.returnBrokenResource(jedis); //释放redis对象,A Jedis object represents a connection to Redis. It becomes unusable when the physical connection is broken, or when the synchronization between the client and server is lost.
        } finally {
            if (borrowOrOprSuccess)
                jedisPool.returnResource(jedis); //返还到连接池,应该放在finally块中，否则每次发生异常将导致一个jedis对象没有被回收
        }
        return result;

    }

    @Override
    public void putObject(Object key, Object value) {
//        if (log.isDebugEnabled())
//            log.debug("putObject:" + key.hashCode() + "=" + value);
//        if (log.isInfoEnabled())
//            log.info("put to redis sql :" + key.toString());
        Jedis jedis = null;
        JedisPool jedisPool = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis = CachePool.getInstance().getJedis();
            jedisPool = CachePool.getInstance().getJedisPool();
//            jedis.set(SerializeUtil.serialize(key.hashCode()), SerializeUtil.serialize(value));
            jedis.setex(SerializeUtil.serialize(key.hashCode()),5, SerializeUtil.serialize(value));
        } catch (JedisConnectionException e) {
            borrowOrOprSuccess = false;
            if (jedis != null)
                jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess)
                jedisPool.returnResource(jedis);
        }

    }

    @Override
    public Object getObject(Object key) {
        Jedis jedis = null;
        JedisPool jedisPool = null;
        Object value = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis = CachePool.getInstance().getJedis();
            jedisPool = CachePool.getInstance().getJedisPool();
            value = SerializeUtil.unserialize(jedis.get(SerializeUtil.serialize(key.hashCode())));
        } catch (JedisConnectionException e) {
            borrowOrOprSuccess = false;
            if (jedis != null)
                jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess)
                jedisPool.returnResource(jedis);
        }
//        if (log.isDebugEnabled())
//            log.debug("getObject:" + key.hashCode() + "=" + value);
        return value;
    }

    @Override
    public Object removeObject(Object key) {
        Jedis jedis = null;
        JedisPool jedisPool = null;
        Object value = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis = CachePool.getInstance().getJedis();
            jedisPool = CachePool.getInstance().getJedisPool();
            value = jedis.expire(SerializeUtil.serialize(key.hashCode()), 0);
        } catch (JedisConnectionException e) {
            borrowOrOprSuccess = false;
            if (jedis != null)
                jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess)
                jedisPool.returnResource(jedis);
        }
//        if (log.isDebugEnabled())
//            log.debug("getObject:" + key.hashCode() + "=" + value);
        return value;
    }

    @Override
    public void clear() {
        Jedis jedis = null;
        JedisPool jedisPool = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis = CachePool.getInstance().getJedis();
            jedisPool = CachePool.getInstance().getJedisPool();
            jedis.flushDB();
            jedis.flushAll();
        } catch (JedisConnectionException e) {
            borrowOrOprSuccess = false;
            if (jedis != null)
                jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess)
                jedisPool.returnResource(jedis);
        }
    }

    public static void main(String[] args){
        MybatisRedisCache c = new MybatisRedisCache("ss");
        c.clear();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }


    public static class CachePool {
        JedisPool pool;
        private static final CachePool cachePool = new CachePool();

        public static CachePool getInstance() {
            return cachePool;
        }

        private CachePool() {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(1024);
            config.setMaxIdle(200);
            config.setMaxWaitMillis(1000l);
            PropertiesConfiguration redisConfig = null;
            try {
                redisConfig = new PropertiesConfiguration("config.properties");
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
            String url = redisConfig.getString("redis.url");
            int port = redisConfig.getInt("redis.port");
            pool = new JedisPool(config, url , port);
        }


        public Jedis getJedis() {
            Jedis jedis = pool.getResource(); //Exception交由具体调用者去catch
            return jedis;
        }

        public JedisPool getJedisPool() {
            return this.pool;
        }

    }


    public static class SerializeUtil {
        public static byte[] serialize(Object object) {
            ObjectOutputStream oos = null;
            ByteArrayOutputStream baos = null;
            try {
                // 序列化
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                byte[] bytes = baos.toByteArray();
                return bytes;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public static Object unserialize(byte[] bytes) {
            if (bytes == null) return null;
            ByteArrayInputStream bais = null;
            try {
                // 反序列化
                bais = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bais);
                return ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
