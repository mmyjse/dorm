/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codestudio.dorm.biz.service.UserProfileService;
import com.codestudio.dorm.domain.UserProfile;
import com.codestudio.dorm.web.context.UserInfo;
import com.codestudio.dorm.web.util.UserAuthUtil;

/**
 * 类UserController.java的实现描述：操作员(小二)用户控制器
 * 
 * @author J 2014-5-14 下午11:40:57
 */
@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserProfileService userProfileService;

	@ResponseBody
	@RequestMapping("getUserProfile")
	public UserProfile getPartyAndAddress(
			@RequestParam("workNumber") String workNumber) {
		UserProfile userProfile = userProfileService
				.getUserProfileByWorkNumber(Long.parseLong(workNumber));
		return userProfile;
	}

	@ResponseBody
	@RequestMapping("getUserId")
	public UserProfile getUserProfile(HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo userInfo = UserAuthUtil.getUserInfo(request, response);
		return userProfileService.getUserProfileByWorkNumber(Long
				.parseLong(userInfo.getWorkNumber()));
	}

	@ResponseBody
	@RequestMapping("getUserList")
	public List<Map<String,Object>> getUserProfileList(HttpServletRequest request,
			HttpServletResponse response) {
		List<UserProfile> list = userProfileService.getUserProfileForList();
//		StringBuilder sb = new StringBuilder("[");
//		if (!list.isEmpty()) {
//			int size = list.size();
//			for (int i = 0; i < size; i++) {
//				UserProfile userProfile = list.get(i);
//				sb.append("{").append("userId:").append("\"")
//						.append(userProfile.getUser().getId()).append("\",")
//						.append("workNumber:").append("\"")
//						.append(userProfile.getWorkNumber()).append("/")
//						.append(userProfile.getName()).append("\",")
//						.append("name:").append("\"")
//						.append(userProfile.getName()).append("\",")
//						.append("mobile:").append("\"")
//						.append(userProfile.getMobile()).append("\"")
//						.append("}");
//				if (i < size) {
//					sb.append(",");
//				}
//			}
//		}
//		sb.append("]");
		List<Map<String,Object>> resultList=new ArrayList<Map<String,Object>>();
		if (!list.isEmpty()) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Map<String,Object> _m=new HashMap<String,Object>();
				UserProfile userProfile = list.get(i);
				_m.put("userId", userProfile.getUser().getId());
				_m.put("workNumber", userProfile.getWorkNumber()+"/"+userProfile.getName());
				_m.put("name", userProfile.getName());
				_m.put("mobile", userProfile.getMobile());
				resultList.add(_m);
			}
		}
		
		return resultList;
	}
}
