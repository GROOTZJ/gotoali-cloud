package com.tzj.redis.util;

import com.tzj.redis.exception.TestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author TianZiJiang
 * @date 2019-08-25
 */
@Component
public class RedisUtils {

    @Autowired
    protected RedisTemplate redisTemplate;

    public void setString(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public void setString(String key, Integer value){
        redisTemplate.opsForValue().set(key, value);
    }

    public void setString(String key, Integer value, Long expireTime){
        redisTemplate.opsForValue().set(key, value, expireTime);
    }

    public void setString(String key, String value, Long expireTime){
        redisTemplate.opsForValue().set(key, value, expireTime);
    }

    public String getString(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        if (o == null) {
            throw new TestException("获取Redis失败：" + key);
        }
        return String.valueOf(o);
    }

}
