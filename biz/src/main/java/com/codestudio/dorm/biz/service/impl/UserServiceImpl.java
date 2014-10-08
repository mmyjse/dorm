/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codestudio.dorm.biz.service.UserService;
import com.codestudio.dorm.dal.UserDao;
import com.codestudio.dorm.domain.User;

/**
 * 类UserServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-5-18 上午3:29:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /*
     * (non-Javadoc)
     * @see com.diqitian.ed.biz.service.UserService#getUserByUserId(long, boolean)
     */
    @Override
    public User getUserByUserId(long userId, boolean isLoadRole) {
        User user = userDao.get(userId);
        if (user != null && isLoadRole) {
            // TODO 加载用户角色
            user.setRoles(null);
        }
        return user;
    }

    /*
     * (non-Javadoc)
     * @see com.diqitian.ed.biz.service.UserService#getUserByWorkNumber(java.lang.String, boolean)
     */
    @Override
    public User getUserByWorkNumber(String workNumber, boolean isLoadRole) {
        User user = userDao.getUserByWorkNumber(workNumber);
        if (user != null && isLoadRole) {
            // TODO 加载用户角色
            user.setRoles(null);
        }
        return user;
    }

}
