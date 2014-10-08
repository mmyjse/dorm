/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.dal;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.codestudio.dorm.dal.base.BaseDao;
import com.codestudio.dorm.domain.User;

/**
 * 类UserDao.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-5-17 下午7:46:41
 */
public interface UserDao extends BaseDao<User, Map<String, Object>> {

    /**
     * 根据员工号获取用户信息
     * 
     * @param workNumber
     * @return
     * @author J 2014-5-29 下午8:37:46
     */
    public User getUserByWorkNumber(@Param("workNumber") String workNumber);
}
