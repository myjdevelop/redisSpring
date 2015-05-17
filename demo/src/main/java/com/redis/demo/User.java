/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis.demo;

import java.io.Serializable;

/**
 *
 * @author asus
 */
public class User implements Serializable {

    /**
     * 用户ID
     */
    private String uid;
    /**
     * 用户对应的地址
     */
    private String address;

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
