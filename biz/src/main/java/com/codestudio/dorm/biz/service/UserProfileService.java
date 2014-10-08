/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.biz.service;

import java.util.List;

import com.codestudio.dorm.domain.UserProfile;

/**
 * 类UserProfileService.java的实现描述：用户基本信息服务
 * 
 * @author J 2014-5-18 上午5:34:40
 */
public interface UserProfileService {

    /**
     * 根据用户ID获取用户详情
     * 
     * @param userId
     * @return
     * @author J 2014-5-18 下午6:04:29
     */
    public UserProfile getUserProfileByUserId(long userId);
    
    /**
     * 根据工号获取用户详情
     * 
     * @param workNumber
     * @return
     * @author CH 2014-5-18 下午1:15:03
     */
    public UserProfile getUserProfileByWorkNumber(long workNumber);
    
    /**
	 * 获得快递员信息
	 * 
	 * @param workNumber
	 * @return
	 * @author CH 2014-5-25 下午1:12:44
	 */
	public List<UserProfile> getUserProfileForList();
}
