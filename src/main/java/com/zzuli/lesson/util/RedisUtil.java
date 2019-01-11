package com.zzuli.lesson.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

import redis.clients.jedis.JedisPool;

/**
 * Created by 
 * @author 
 */
@Component
public class RedisUtil {
	 //private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);
	 @Autowired
	 private JedisPool jedisPool;
	 
	// jedisPool = new JedisPool("redis://localhost:6379");
	  /**
     * 存储String
     *
     * @param key   key
     * @param value String
     * @throws Exception e
     */
    public void setString(String key, String value) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } finally {
            //返还到连接池
        	if(jedis != null) {
        		jedis.close();
        	}
        }
    }
 
    /**
     * 获取String
     *
     * @param key key
     * @return String
     * @throws Exception e
     */
    public String getString(String key) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } finally {
        	//返还到连接池
        	if(jedis != null) {
        		jedis.close();
        	}
        }
    }
    

	/**
	 * 自增 +1
	 *
	 * @param key
	 * @return 返回自增后结果
	 * @since qlchat 1.0
	 */
	public Long incr(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.incr(key);
		} finally {
			if(jedis != null) {
        		jedis.close();
        	}
		}
	}
 
	/**
	 * 自增 +1
	 *
	 * @param key key
	 * @param integer 起始值
	 * @return 返回自增后结果
	 * @since qlchat 1.0
	 */
	public Long incrBy(String key, long integer) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.incrBy(key, integer);
		} finally {
			if(jedis != null) {
        		jedis.close();
        	}
		}
	}


    


}