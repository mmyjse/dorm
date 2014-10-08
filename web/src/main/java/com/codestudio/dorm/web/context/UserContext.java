/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codestudio.dorm.domain.User;

/**
 * 类UserContext.java的实现描述：用户上下文
 * 
 * @author J 2013-7-24 上午2:48:58
 */
public interface UserContext {

    /**
     * 用户登录系统
     * 
     * @param loginId
     * @param password
     * @param validCode
     * @return
     */
    public ResponseResult doLogin(String loginId, String password, String validCode, HttpServletRequest request,
                                  HttpServletResponse response);

    /**
     * 退出系统
     */
    public void doLogout(HttpServletRequest request, HttpServletResponse response);

    /**
     * 获取用户登录信息
     * 
     * @return
     */
    public UserInfo getUserInfo(HttpServletRequest request, HttpServletResponse response);

    /**
     * 初始化用户上下文
     */
    public void initContext(User user, HttpServletRequest request, HttpServletResponse response);

    /**
     * 刷新用户登录COOKIE信息
     */
    public void refreshUserInfo(HttpServletRequest request, HttpServletResponse response);

}
