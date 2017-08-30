package com.we.p2p.util.cache;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.*;

public class RedisClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(RedisClientUtils.class);

    private ShardedJedisPool writePool = null;

    private ConnectionFactoryBuilder connectionFactoryBuilder = null;

    private List<String> masterConfList = null;

    public RedisClientUtils(ConnectionFactoryBuilder connectionFactoryBuilder, List<String> masterConfList) {
        this.connectionFactoryBuilder = connectionFactoryBuilder;
        this.masterConfList = masterConfList;
        init();
    }

    private void init() {
        logger.info("---------init start---------");
        List<JedisShardInfo> wShards = null;

        if (StringUtils.isNotBlank(connectionFactoryBuilder.getMasterConfString())) {
            masterConfList = Arrays.asList(connectionFactoryBuilder.getMasterConfString().split("(?:\\s|,)+"));
        }

        if (CollectionUtils.isEmpty(masterConfList)) {
            throw new ExceptionInInitializerError("masterConfString is empty！");
        }

        wShards = new LinkedList<JedisShardInfo>();
        for (String wAddr : masterConfList) {
            String[] wAddrArray = wAddr.split(":");
            if (wAddrArray.length == 1) {
                throw new ExceptionInInitializerError(wAddr + " is not include host:port or host:port:passwd after split \":\"");
            }

            String host = wAddrArray[0];
            int port = Integer.valueOf(wAddrArray[1]);
            JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port, connectionFactoryBuilder.getTimeout());
            logger.info("masterConfList:" + jedisShardInfo.toString());
            // 检查密码是否需要设置
            if (wAddrArray.length == 3 && StringUtils.isNotBlank(wAddrArray[2])) {
                jedisShardInfo.setPassword(wAddrArray[2]);
            }
            wShards.add(jedisShardInfo);
        }

        this.writePool = new ShardedJedisPool(connectionFactoryBuilder.getJedisPoolConfig(), wShards);
        logger.info("---------init end---------");
    }

    public String getShardInfo(String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        String result = null;
        try {
            j = writePool.getResource();
            result = j.getShardInfo(key).toString();
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 除给定的key
     * 
     * @param key
     * @return 被删除 key 的数量
     * @throws RedisAccessException
     */
    public Long del(String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.del(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 返回 key 所关联的字符串值
     * 
     * @param key
     * @return 当 key 不存在时，返回 nil ，否则，返回 key 的值
     * @throws RedisAccessException
     */
    public String get(String key) throws RedisAccessException {
        String result = null;
        ShardedJedis j = null;
        boolean flag = true;
        try {
            j = writePool.getResource();
            result = j.get(key);
        } catch (Exception ex) {
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 检查给定 key 是否存在
     * 
     * @param key
     * @return
     * @throws RedisAccessException
     */
    public Boolean exists(String key) throws RedisAccessException {
        Boolean result = null;
        ShardedJedis j = null;
        boolean flag = true;
        try {
            j = writePool.getResource();
            result = j.exists(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 返回 key 所储存的值的类型
     * 
     * @param key
     * @return
     * @throws RedisAccessException
     */
    public String type(String key) throws RedisAccessException {
        String result = null;
        ShardedJedis j = null;
        boolean flag = true;
        try {
            j = writePool.getResource();
            result = j.type(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除
     * 
     * @param key
     * @param seconds
     * @return
     * @throws RedisAccessException
     */
    public Long expire(String key, int seconds) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.expire(key, seconds);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 为给定 key 设置生存时间，当 key 到达给定时间戳之后，它会被自动删除
     * 
     * @param key
     * @param unixTime
     * @return
     * @throws RedisAccessException
     */
    public Long expireAt(String key, long unixTime) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.expireAt(key, unixTime);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 以秒为单位，返回给定 key 的剩余生存时间
     * 
     * @param key
     * @return
     * @throws RedisAccessException
     */
    public Long ttl(String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.ttl(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)<br>
     * 当 key 存在但不是字符串类型时，返回一个错误
     * 
     * @param key
     * @param value
     * @return
     *         返回给定 key 的旧值
     * @throws RedisAccessException
     */
    public String getSet(String key, String value) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        String result = null;
        try {
            j = writePool.getResource();
            result = j.getSet(key, value);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将字符串值 value 关联到 key<br>
     * 如果 key 已经持有其他值， SET 就覆写旧值，无视类型
     * 
     * @param key
     * @param value
     * @return
     *         SET 在设置操作成功完成时，才返回 OK
     * @throws RedisAccessException
     */
    public String set(String key, String value) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        String result = null;
        try {
            j = writePool.getResource();
            result = j.set(key, value);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将 key 的值设为 value ，当且仅当 key 不存在<br>
     * 若给定的 key 已经存在，则 SETNX 不做任何动作
     * 
     * @param key
     * @param value
     * @return
     *         设置成功，返回 1 <br>
     *         设置失败，返回 0
     * @throws RedisAccessException
     */
    public Long setnx(String key, String value) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.setnx(key, value);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将值 value 关联到 key ，并将 key 的生存时间设为 seconds (以秒为单位)<br>
     * 如果 key 已经存在， SETEX 命令将覆写旧值
     * 
     * @param key
     * @param seconds
     * @param value
     * @return
     *         设置成功时返回 OK
     * @throws RedisAccessException
     */
    public String setex(String key, int seconds, String value) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        String result = null;
        try {
            j = writePool.getResource();
            result = j.setex(key, seconds, value);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将 key 所储存的值减去减量 decrement <br>
     * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECRBY 操作
     * 
     * @param key
     * @param integer
     * @return
     *         减去 decrement 之后， key 的值
     * @throws RedisAccessException
     */
    public Long decrBy(String key, long integer) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.decrBy(key, integer);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将 key 中储存的数字值减一 <br>
     * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECR 操作
     * 
     * @param key
     * @return
     *         执行 DECR 命令之后 key 的值
     * @throws RedisAccessException
     */
    public Long decr(String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.decr(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将 key 所储存的值加上增量 increment <br>
     * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCRBY 命令
     * 
     * @param key
     * @param integer
     * @return
     *         加上 increment 之后， key 的值
     * @throws RedisAccessException
     */
    public Long incrBy(String key, long integer) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.incrBy(key, integer);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将 key 中储存的数字值增一 <br>
     * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作
     * 
     * @param key
     * @return
     *         执行 INCR 命令之后 key 的值
     * @throws RedisAccessException
     */
    public Long incr(String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.incr(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾<br>
     * 如果 key 不存在， APPEND 就简单地将给定 key 设为 value ，就像执行 SET key value 一样
     * 
     * @param key
     * @param value
     * @return
     *         追加 value 之后， key 中字符串的长度
     * @throws RedisAccessException
     */
    public Long append(String key, String value) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.append(key, value);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    public String substr(String key, int start, int end) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        String result = null;
        try {
            j = writePool.getResource();
            result = j.substr(key, start, end);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将哈希表 key 中的域 field 的值设为 value<br>
     * 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作<br>
     * 如果域 field 已经存在于哈希表中，旧值将被覆盖
     * 
     * @param key
     * @param field
     * @param value
     * @return
     *         如果 field 是哈希表中的一个新建域，并且值设置成功，返回 1<br>
     *         如果哈希表中域 field 已经存在且旧值已被新值覆盖，返回 0
     * @throws RedisAccessException
     */
    public Long hset(String key, String field, String value) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.hset(key, field, value);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 返回哈希表 key 中给定域 field 的值
     * 
     * @param key
     * @param field
     * @return
     *         给定域的值<br>
     *         当给定域不存在或是给定 key 不存在时，返回 nil
     * @throws RedisAccessException
     */
    public String hget(String key, String field) throws RedisAccessException {
        String result = null;
        ShardedJedis j = null;
        boolean flag = true;
        try {
            j = writePool.getResource();
            result = j.hget(key, field);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将哈希表 key 中的域 field 的值设置为 value ，当且仅当域 field 不存在<br>
     * 若域 field 已经存在，该操作无效<br>
     * 如果 key 不存在，一个新哈希表被创建并执行 HSETNX 命令
     * 
     * @param key
     * @param field
     * @param value
     * @return
     *         设置成功，返回 1,<br>
     *         如果给定域已经存在且没有操作被执行，返回 0
     * @throws RedisAccessException
     */
    public Long hsetnx(String key, String field, String value) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.hsetnx(key, field, value);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 同时将多个 field-value (域-值)对设置到哈希表 key 中<br>
     * 此命令会覆盖哈希表中已存在的域<br>
     * 如果 key 不存在，一个空哈希表被创建并执行 HMSET 操作
     * 
     * @param key
     * @param hash
     * @return
     *         如果命令执行成功，返回 OK
     * @throws RedisAccessException
     */
    public String hmset(String key, Map<String, String> hash) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        String result = null;
        try {
            j = writePool.getResource();
            result = j.hmset(key, hash);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 返回哈希表 key 中，一个或多个给定域的值<br>
     * 如果给定的域不存在于哈希表，那么返回一个 nil 值
     * 
     * @param key
     * @param fields
     * @return
     *         一个包含多个给定域的关联值的表，表值的排列顺序和给定域参数的请求顺序一样
     * @throws RedisAccessException
     */
    public List<String> hmget(String key, String... fields) throws RedisAccessException {
        List<String> result = null;
        ShardedJedis j = null;
        boolean flag = true;
        try {
            j = writePool.getResource();
            result = j.hmget(key, fields);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 为哈希表 key 中的域 field 的值加上增量 increment<br>
     * 增量也可以为负数，相当于对给定域进行减法操作<br>
     * 如果 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令<br>
     * 如果域 field 不存在，那么在执行命令前，域的值被初始化为 0
     * 
     * @param key
     * @param field
     * @param value
     * @return
     *         执行 HINCRBY 命令之后，哈希表 key 中域 field 的值
     * @throws RedisAccessException
     */
    public Long hincrBy(String key, String field, long value) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.hincrBy(key, field, value);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 查看哈希表 key 中，给定域 field 是否存在
     * 
     * @param key
     * @param field
     * @return
     *         如果哈希表含有给定域，返回 1<br>
     *         如果哈希表不含有给定域，或 key 不存在，返回 0
     * @throws RedisAccessException
     */
    public Boolean hexists(String key, String field) throws RedisAccessException {
        Boolean result = null;
        ShardedJedis j = null;
        boolean flag = true;
        try {
            j = writePool.getResource();
            result = j.hexists(key, field);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略
     * 
     * @param key
     * @param field
     * @return
     *         被成功移除的域的数量，不包括被忽略的域
     * @throws RedisAccessException
     */
    public Long hdel(String key, String field) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.hdel(key, field);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将列表 key 下标为 index 的元素的值设置为 value<br>
     * 当 index 参数超出范围，或对一个空列表( key 不存在)进行 LSET 时，返回一个错误
     * 
     * @param key
     * @param index
     * @param value
     * @return
     *         操作成功返回 ok ，否则返回错误信息
     * @throws RedisAccessException
     */
    public String lset(String key, int index, String value) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        String result = null;
        try {
            j = writePool.getResource();
            result = j.lset(key, index, value);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 根据参数 count 的值，移除列表中与参数 value 相等的元素<br>
     * count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count<br>
     * count < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值<br>
     * count = 0 : 移除表中所有与 value 相等的值。
     * 
     * @param key
     * @param count
     * @param value
     * @return
     *         被移除元素的数量<br>
     *         因为不存在的 key 被视作空表(empty list)，所以当 key 不存在时， LREM 命令总是返回 0
     * @throws RedisAccessException
     */
    public Long lrem(String key, int count, String value) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.lrem(key, count, value);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表头<br>
     * 当 key 存在但不是列表类型时，返回一个错误
     * 
     * @param key
     * @param values
     * @return
     *         执行 LPUSH 命令后，列表的长度
     * @throws RedisAccessException
     */
    public long lpush(String key, String... values) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.lpush(key, values);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 移除并返回列表 key 的头元素
     * 
     * @param key
     * @return
     *         列表的头元素<br>
     *         当 key 不存在时，返回 nil
     * @throws RedisAccessException
     */
    public String lpop(String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        String result = null;
        try {
            j = writePool.getResource();
            result = j.lpop(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 移除并返回列表 key 的尾元素
     * 
     * @param key
     * @return
     *         列表的尾元素<br>
     *         当 key 不存在时，返回 nil
     * @throws RedisAccessException
     */
    public String rpop(String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        String result = null;
        try {
            j = writePool.getResource();
            result = j.rpop(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 它是 RPOP 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 BRPOP 命令阻塞，直到等待超时或发现可弹出元素为止
     * 
     * @param key
     * @return
     *         假如在指定时间内没有任何元素被弹出，则返回一个 nil 和等待时长<br>
     *         反之，返回一个含有两个元素的列表，第一个元素是被弹出元素所属的 key ，第二个元素是被弹出元素的值
     * @throws RedisAccessException
     */
    public List<String> brpop(String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        List<String> result = null;
        try {
            j = writePool.getResource();
            result = j.brpop(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 
     * @param timeout
     * @param key
     * @return
     * @throws RedisAccessException
     */
    public List<String> brpop(int timeout, String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        List<String> result = null;
        try {
            j = writePool.getResource();
            result = j.brpop(timeout, key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略<br>
     * 假如 key 不存在，则创建一个只包含 member 元素作成员的集合<br>
     * 当 key 不是集合类型时，返回一个错误
     * 
     * @param key
     * @param member
     * @return
     *         被添加到集合中的新元素的数量，不包括被忽略的元素
     * @throws RedisAccessException
     */
    public Long sadd(String key, String... member) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.sadd(key, member);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 移除集合 key 中的一个或多个 member 元素，不存在的 member 元素会被忽略<br>
     * 当 key 不是集合类型，返回一个错误
     * 
     * @param key
     * @param member
     * @return
     *         被成功移除的元素的数量，不包括被忽略的元素
     * @throws RedisAccessException
     */
    public Long srem(String key, String... member) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.srem(key, member);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 移除并返回集合中的一个随机元素
     * 
     * @param key
     * @return
     *         被移除的随机元素<br>
     *         当 key 不存在或 key 是空集时，返回 nil
     * @throws RedisAccessException
     */
    public String spop(String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        String result = null;
        try {
            j = writePool.getResource();
            result = j.spop(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中<br>
     * 当 key 存在但不是有序集类型时，返回一个错误
     * 
     * @param key
     * @param score
     * @param member
     * @return
     *         被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员
     * @throws RedisAccessException
     */
    public Long zadd(String key, double score, String member) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.zadd(key, score, member);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 移除有序集 key 中的一个或多个成员，不存在的成员将被忽略<br>
     * 当 key 存在但不是有序集类型时，返回一个错误
     * 
     * @param key
     * @param member
     * @return
     *         被成功移除的成员的数量，不包括被忽略的成员
     * @throws RedisAccessException
     */
    public Long zrem(String key, String... member) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Long result = null;
        try {
            j = writePool.getResource();
            result = j.zrem(key, member);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 为有序集 key 的成员 member 的 score 值加上增量 increment<br>
     * 可以通过传递一个负数值 increment ，让 score 减去相应的值<br>
     * 当 key 不是有序集类型时，返回一个错误
     * 
     * @param key
     * @param score
     * @param member
     * @return
     *         member 成员的新 score 值
     * @throws RedisAccessException
     */
    public Double zincrby(String key, double score, String member) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        double result = -1;
        try {
            j = writePool.getResource();
            result = j.zincrby(key, score, member);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

    /**
     * 返回set中的所有成员
     * @param key
     * @return
     * @throws RedisAccessException
     */
    public Set<String> smembers(String key) throws RedisAccessException {
        boolean flag = true;
        ShardedJedis j = null;
        Set<String> result = null;
        try {
            j = writePool.getResource();
            result = j.smembers(key);
        } catch (Exception ex) {
            flag = false;
            writePool.returnBrokenResource(j);
            throw new RedisAccessException(ex + "," + j.getShardInfo(key).toString());
        } finally {
            if (flag) {
                writePool.returnResource(j);
            }
        }
        return result;
    }

}
