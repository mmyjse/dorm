/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.web.form.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 类FormError.java的实现描述：表单验证返回类型
 * 
 * @author mmy 2014年5月1日 上午6:41:16
 */
public class FormError {

    private Map<String, FormMessage> messages;

    public Map<String, FormMessage> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, FormMessage> messages) {
        this.messages = messages;
    }

    public void add(String key, FormMessage message) {
        if (this.messages == null) {
            this.messages = new HashMap<String, FormMessage>();
        }
        this.messages.put(key, message);
    }

    public boolean hasErrors() {
        if (this.messages == null || this.messages.isEmpty()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
