/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codestudio.dorm.biz.service.FunctionsService;
import com.codestudio.dorm.dal.FunctionsDao;
import com.codestudio.dorm.domain.Functions;

/**
 * 类FunctionsServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-5-29 下午8:44:39
 */
@Service("functionsService")
public class FunctionsServiceImpl implements FunctionsService {

    @Autowired
    private FunctionsDao functionsDao;

    /*
     * (non-Javadoc)
     * @see com.diqitian.ed.biz.service.FunctionsService#getFunctionsByUserId(long, java.lang.Long)
     */
    @Override
    public List<Functions> getFunctionsByUserId(long userId, Long parentId) {
        return functionsDao.getFunctionsByUserId(userId, parentId);
    }

}
