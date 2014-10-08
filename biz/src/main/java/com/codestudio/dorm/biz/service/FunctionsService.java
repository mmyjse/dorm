/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.biz.service;

import java.util.List;

import com.codestudio.dorm.domain.Functions;

/**
 * 类FunctionsService.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-5-18 上午12:16:22
 */
public interface FunctionsService {

    /**
     * 按用户查询有权限资源列表
     * 
     * @param userId
     * @param parentId
     * @return
     * @author J 2014-5-30 上午12:27:55
     */
    public List<Functions> getFunctionsByUserId(long userId, Long parentId);
}
