/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis;

import com.redis.dao.UserDao;
import com.redis.demo.User;
import com.redis.util.ApplicationContextUtil;

/**
 *
 * @author asus
 */
public class redisMain {

    public static void main(String[] args) {

        User user = new User();
        user.setUid("123456");
        user.setAddress("浙江省");
        UserDao userDao = (UserDao) ApplicationContextUtil.getBeanByBeanName("userDao");
        userDao.save(user);

        User ru = userDao.getUserInfoById("123456");
        System.out.println("address = " + ru.getAddress());

    }
}
