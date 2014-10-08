/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.domain;

import java.io.Serializable;


/**
 * 类Example.java的实现描述：TODO 类实现描述 
 * @author mmy 2014年5月1日 上午5:53:58
 */
public class Example implements Serializable {

    private static final long serialVersionUID = 8912788227309918855L;

    private Long              id;
    private String            name;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Example [id=" + id + ", name=" + name + "]";
    }

}
