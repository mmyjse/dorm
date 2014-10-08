/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codestudio.dorm.biz.service.RoleService;
import com.codestudio.dorm.dal.RoleDao;
import com.codestudio.dorm.domain.Role;

/**
 * 类RoleServiceImpl.java的实现描述：角色服务
 * 
 * @author J 2014-5-18 上午3:32:12
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /*
     * (non-Javadoc)
     * @see com.diqitian.ed.biz.service.RoleService#getRolesByUserId(long, boolean)
     */
    @Override
    public List<Role> getRolesByUserId(long userId, boolean isLoadFunctions) {
        // TODO Auto-generated method stub
        return null;
    }

}
