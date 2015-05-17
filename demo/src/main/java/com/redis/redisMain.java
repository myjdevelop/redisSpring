/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis;

import com.redis.dao.UserDao;
import com.redis.demo.User;
import com.redis.util.ApplicationContextUtil;
import com.redis.util.StringOps;

/**
 *
 * @author asus
 */
public class redisMain {

    public static StringOps stringOps = null;

    static {
        stringOps = (StringOps) ApplicationContextUtil.getBeanByBeanName("stringOps");
    }

    public static void main(String[] args) {
        setValue();
        getValue();
        deleteValue();
        getValue();
    }

    public static void setValue() {
        stringOps.setValue("name", "Bill");

    }

    public static void getValue() {
        String name = stringOps.getValue("name");
        System.out.println("name = " + name);
    }

    public static void deleteValue() {
        stringOps.deleteValue("name");
    }
}
