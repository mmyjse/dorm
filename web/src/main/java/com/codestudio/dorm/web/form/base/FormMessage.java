/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.web.form.base;

/**
 * 类FormMessage.java的实现描述：表单验证消息
 * 
 * @author mmy 2014年5月1日 上午6:40:34
 */
public class FormMessage {

    private String key;
    private String value;

    /**
     * @param key
     * @param value
     */
    public FormMessage(String key, String value){
        super();
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FormMessage [key=" + key + ", value=" + value + "]";
    }
}
