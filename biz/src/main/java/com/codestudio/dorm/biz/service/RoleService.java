/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.biz.service;

import java.util.List;

import com.codestudio.dorm.domain.Role;

/**
 * 类RoleService.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-5-18 上午12:18:20
 */
public interface RoleService {

    /**
     * 根据用户ID获取角色列表
     * 
     * @param userId
     * @param isLoadFunctions
     * @return
     * @author J 2014-5-18 上午3:33:14
     */
    public List<Role> getRolesByUserId(long userId, boolean isLoadFunctions);
}
