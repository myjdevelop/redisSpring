/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis.dao.impl;

import com.redis.dao.UserDao;
import com.redis.demo.User;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asus
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    public void save(final User user) {
        redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.set(
                        redisTemplate.getStringSerializer().serialize(
                        "user.uid." + user.getUid()),
                        redisTemplate.getStringSerializer().serialize(
                        user.getAddress()));
                return null;
            }
        });
    }

    public User getUserInfoById(final String uid) {
        return redisTemplate.execute(new RedisCallback<User>() {

            @Override
            public User doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize(
                        "user.uid." + uid);
                if (connection.exists(key)) {
                    byte[] value = connection.get(key);
                    String address = redisTemplate.getStringSerializer().deserialize(value);
                    User user = new User();
                    user.setAddress(address);
                    user.setUid(uid);
                    return user;
                }
                return null;
            }
        });
    }

    public void deleteUserInfoById(final String uid) {
        redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection connection) {
                connection.del(redisTemplate.getStringSerializer().serialize(
                        "user.uid." + uid));
                return null;
            }
        });
    }
}
