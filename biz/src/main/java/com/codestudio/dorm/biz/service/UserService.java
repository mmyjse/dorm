/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.biz.service;

import com.codestudio.dorm.domain.User;

/**
 * 类UserService.java的实现描述：用户服务
 * 
 * @author J 2014-5-18 上午12:18:08
 */
public interface UserService {

    /**
     * 根据用户ID获取用户信息
     * 
     * @param userId
     * @param isLoadRole
     * @return
     * @author J 2014-5-18 上午3:28:52
     */
    public User getUserByUserId(long userId, boolean isLoadRole);

    /**
     * 根据员工号获取用户信息
     * 
     * @param workNumber 员工号
     * @param isLoadRole
     * @return
     * @author J 2014-5-29 下午8:35:52
     */
    public User getUserByWorkNumber(String workNumber, boolean isLoadRole);
}
