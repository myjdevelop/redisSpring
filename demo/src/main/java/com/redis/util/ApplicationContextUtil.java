/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author asus
 */
public class ApplicationContextUtil {

    public static ApplicationContext context = null;

    private ApplicationContextUtil() {
    }

    public static ApplicationContext getInstance() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        }
        return context;
    }

    public static Object getBeanByBeanName(String beanName) {
        getInstance();
        return context.getBean(beanName);
    }
}
