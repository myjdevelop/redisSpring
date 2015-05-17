/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis.util;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author asus
 */
@Component("stringOps")
public class StringOps {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 通过key获取值
     * @param key
     * @return 
     */
    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 设置key - value对应的值
     * @param key
     * @param value 
     */
    public void setValue(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 删除value
     * @param key 
     */
    public void deleteValue(String key) {
        stringRedisTemplate.delete(key);
    }
}
