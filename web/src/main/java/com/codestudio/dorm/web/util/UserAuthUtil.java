/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;

import com.codestudio.dorm.common.cookie.UserCookieManager;
import com.codestudio.dorm.domain.User;
import com.codestudio.dorm.web.context.UserInfo;

/**
 * 类UserAuthUtil.java的实现描述：用户授权工具
 * 
 * @author J 2013-4-8 下午2:56:52
 */
public class UserAuthUtil {

    /**
     * 取得当前登录用户信息，未登录返回null
     * 
     * @param request
     * @param response
     * @return
     */
    public static UserInfo getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        UserInfo userInfo = null;
        // UserCookieManager userCookieManager = new UserCookieManager(request, response, null, "/");
        // String userId = userCookieManager.getTempCookie(UserCookieManager.USER_ID, null);
        //
        // if (StringUtils.isNotBlank(userId)) {
        // userInfo = new UserInfo();
        // userInfo.setId(Long.valueOf(userId));
        // userInfo.setLoginName(userCookieManager.getTempCookie(UserCookieManager.USER_LOGIN_NAME, null));
        // userInfo.setName(userCookieManager.getTempCookie(UserCookieManager.USER_NAME, null));
        // userInfo.setWorkNumber(userCookieManager.getTempCookie(UserCookieManager.USER_WORK_NUMBER, null));
        // String userType = userCookieManager.getTempCookie(UserCookieManager.USER_TYPE, null);
        // userInfo.setUserType(UserType.valueOf(userType));
        // }

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user != null) {
            userInfo = new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setLoginName(user.getLoginName());
            userInfo.setName(null);
            userInfo.setWorkNumber(user.getWorkNumber());
            userInfo.setUserType(user.getUserType());
        }

        return userInfo;
    }

    /**
     * 取得当前登录用户标识，未登录返回null
     * 
     * @param request
     * @param response
     * @return
     */
    public static Long getUserId(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user != null) {
            return user.getId();
        }

        // UserCookieManager userCookieManager = new UserCookieManager(request, response, null, "/");
        // String userId = userCookieManager.getTempCookie(UserCookieManager.USER_ID, null);
        // if (StringUtils.isNotBlank(userId)) {
        // return Long.valueOf(userId);
        // }
        return null;
    }

    /**
     * 判断当前是否登录状态
     * 
     * @param request
     * @param response
     * @return
     */
    public static boolean isSignIn(HttpServletRequest request, HttpServletResponse response) {
        UserCookieManager userCookieManager = new UserCookieManager(request, response, null, "/");
        String userId = userCookieManager.getTempCookie(UserCookieManager.USER_ID, null);
        return StringUtils.isNotBlank(userId);
    }

    /**
     * 登录，写cookie
     * 
     * @param userInfo
     * @param request
     * @param response
     */
    public static void signIn(UserInfo userInfo, HttpServletRequest request, HttpServletResponse response) {
        if (userInfo != null) {
            UserCookieManager userCookieManager = new UserCookieManager(request, response, null, "/");// "bew.jwsz.net"
            userCookieManager.setTempCookie(UserCookieManager.USER_ID, "" + userInfo.getId());
            userCookieManager.setTempCookie(UserCookieManager.USER_LOGIN_NAME, userInfo.getLoginName());
            userCookieManager.setTempCookie(UserCookieManager.USER_NAME, userInfo.getName());
            userCookieManager.setTempCookie(UserCookieManager.USER_TYPE, userInfo.getUserType().toString());
            userCookieManager.setTempCookie(UserCookieManager.USER_WORK_NUMBER, "" + userInfo.getWorkNumber());
            userCookieManager.saveTempCookie();
        }
    }

    /**
     * 登出
     * 
     * @param request
     * @param response
     */
    public static void signOut(HttpServletRequest request, HttpServletResponse response) {
        UserCookieManager userCookieManager = new UserCookieManager(request, response, null, "/");
        userCookieManager.setTempCookie(UserCookieManager.USER_ID, null);
        userCookieManager.removeTempCookie(UserCookieManager.USER_ID);
        userCookieManager.setTempCookie(UserCookieManager.USER_LOGIN_NAME, null);
        userCookieManager.removeTempCookie(UserCookieManager.USER_LOGIN_NAME);
        userCookieManager.setTempCookie(UserCookieManager.USER_NAME, null);
        userCookieManager.removeTempCookie(UserCookieManager.USER_NAME);
        userCookieManager.setTempCookie(UserCookieManager.USER_TYPE, null);
        userCookieManager.removeTempCookie(UserCookieManager.USER_TYPE);
        userCookieManager.setTempCookie(UserCookieManager.USER_WORK_NUMBER, null);
        userCookieManager.removeTempCookie(UserCookieManager.USER_WORK_NUMBER);
        userCookieManager.saveTempCookie();
    }
}
