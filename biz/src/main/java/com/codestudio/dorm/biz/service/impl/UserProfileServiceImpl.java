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

import com.codestudio.dorm.biz.service.UserProfileService;
import com.codestudio.dorm.dal.UserProfileDao;
import com.codestudio.dorm.domain.UserProfile;

/**
 * 类UserProfileServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-5-18 上午5:34:51
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    /*
     * (non-Javadoc)
     * @see com.diqitian.ed.biz.service.UserProfileService#getUserProfileByUserId(long)
     */
    @Override
    public UserProfile getUserProfileByUserId(long userId) {
        return userProfileDao.getUserProfileByUserId(userId);
    }

	@Override
	public UserProfile getUserProfileByWorkNumber(long workNumber) {
		return userProfileDao.getUserProfileByWorkNumber(workNumber);
	}

	@Override
	public List<UserProfile> getUserProfileForList() {
		return userProfileDao.getUserProfileForList();
	}

}
