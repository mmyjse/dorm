/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.dal;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.codestudio.dorm.dal.base.BaseDao;
import com.codestudio.dorm.domain.Functions;

/**
 * 类FunctionsDao.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-5-17 下午7:48:26
 */
public interface FunctionsDao extends BaseDao<Functions, Map<String, Object>> {

    /**
     * 按用户查询有权限资源列表
     * 
     * @param userId
     * @param parentId
     * @return
     * @author J 2014-5-30 上午12:14:11
     */
    public List<Functions> getFunctionsByUserId(@Param("userId") long userId, @Param("parentId") Long parentId);

}
