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
import com.codestudio.dorm.domain.UserProfile;

/**
 * 类UserProfileDao.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-5-18 上午5:33:59
 */
public interface UserProfileDao extends
		BaseDao<UserProfile, Map<String, Object>> {

	/**
	 * 根据用户ID获取用户详情
	 * 
	 * @param userId
	 * @return
	 * @author J 2014-5-18 下午6:06:16
	 */
	public UserProfile getUserProfileByUserId(@Param("userId") long userId);

	/**
	 * 根据工号获取用户详情
	 * 
	 * @param workNumber
	 * @return
	 * @author CH 2014-5-25 下午1:12:44
	 */
	public UserProfile getUserProfileByWorkNumber(
			@Param("workNumber") long workNumber);

	/**
	 * 获得快递员信息
	 * 
	 * @return
	 * @author CH 2014-5-25 下午1:12:44
	 */
	public List<UserProfile> getUserProfileForList();

}
