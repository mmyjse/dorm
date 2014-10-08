/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 类Role.java的实现描述：角色
 * 
 * @author J 2014-5-17 下午6:16:35
 */
public class Role implements Serializable {

    private static final long serialVersionUID = -2658636226666367842L;

    private Long              id;
    private String            name;                                    // 角色名称
    private String            remark;                                  // 角色描述
    private List<Functions>   functions;                               // 功能菜单

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Functions> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Functions> functions) {
        this.functions = functions;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + ", remark=" + remark + ", functions=" + functions + "]";
    }

}
