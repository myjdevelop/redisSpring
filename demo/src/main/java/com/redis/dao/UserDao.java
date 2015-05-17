/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis.dao;

import com.redis.demo.User;

/**
 *
 * @author asus
 */
public interface UserDao {

    /**
     * 新增用户
     * @param user 
     */
    public void save(User user);

    /**
     * 通过用户ID获取用户信息
     * @param uid
     * @return 
     */
    public User getUserInfoById(String uid);

    /**
     * 通过用户ID获取删除用户信息
     * @param uid 
     */
    public void deleteUserInfoById(String uid);
}
