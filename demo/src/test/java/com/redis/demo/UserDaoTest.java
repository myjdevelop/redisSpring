package com.redis.demo;

import static org.junit.Assert.*;
import com.redis.dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
public class UserDaoTest {

    private ApplicationContext app;
    private UserDao userDao;

    @Before
    public void before() throws Exception {
        app = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDao = (UserDao) app.getBean("userDao");
    }

    @Test
    public void crud() {
        saveUserInfoTest();
        //upDateUserInfoTest();
        deleteUserInfoTest();
    }

    public void saveUserInfoTest() {
        String uid = "u123456";
        String address1 = "上海";
        User user = new User();
        user.setAddress(address1);
        user.setUid(uid);
        userDao.save(user);
        getUserInfoByIdTest(uid);
    }

    public void getUserInfoByIdTest(String uid) {
        String address1 = "上海";
        User user = userDao.getUserInfoById(uid);
        assertEquals(address1, user.getAddress());
    }

    public void upDateUserInfoTest() {
        User user = new User();
        String uid = "u123456";
        String address2 = "北京";
        user.setUid(uid);
        user.setAddress(address2);
        userDao.save(user);
        getUserInfoByIdTest(uid);
    }

    public void deleteUserInfoTest() {
        String uid = "u123456";
        userDao.deleteUserInfoById(uid);
        User user = userDao.getUserInfoById(uid);
        assertNull(user);
    }
}
