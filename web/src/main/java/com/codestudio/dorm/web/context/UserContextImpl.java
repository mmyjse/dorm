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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.codestudio.dorm.biz.service.UserService;
import com.codestudio.dorm.common.encrypt.MD5;
import com.codestudio.dorm.domain.User;
import com.codestudio.dorm.web.util.UserAuthUtil;

/**
 * 类UserContextImpl.java的实现描述：用户上下文实现
 * 
 * @author J 2013-7-24 上午2:58:18
 */
@Service
public class UserContextImpl implements UserContext {

    @Autowired
    private UserService userService;

    /*
     * (non-Javadoc)
     * @see net.jwsz.bew.portal.web.context.UserContext#initContext()
     */
    @Override
    public void initContext(User user, HttpServletRequest request, HttpServletResponse response) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setLoginName(user.getLoginName());
        userInfo.setName(null);
        userInfo.setUserType(user.getUserType());
        userInfo.setWorkNumber(user.getWorkNumber());
        UserAuthUtil.signIn(userInfo, request, response);
    }

    /*
     * (non-Javadoc)
     * @see net.jwsz.bew.portal.web.context.UserContext#doLogin(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public ResponseResult doLogin(String loginId, String password, String validCode, HttpServletRequest request,
                                  HttpServletResponse response) {
        Assert.notNull(loginId, "loginId can not blank!");
        Assert.notNull(password, "password can not blank!");

        ResponseResult responseResult = new ResponseResult();
        User user = null;// userService.getUserByLoginId(loginId);
        if (user == null) return null;
        if (!MD5.getMD5(password.getBytes()).equals(user.getPassword())) return null;
        // if (user.isEnable()) {
        responseResult.setSuccess(Boolean.TRUE);
        this.initContext(user, request, response);
        // } else {
        // responseResult.setSuccess(Boolean.FALSE);
        // responseResult.setErrorMsg("帐户存在异常，暂时无法登录系统");
        // }
        return responseResult;
    }

    /*
     * (non-Javadoc)
     * @see net.jwsz.bew.portal.web.context.UserContext#doLogout()
     */
    @Override
    public void doLogout(HttpServletRequest request, HttpServletResponse response) {
        UserAuthUtil.signOut(request, response);
    }

    /*
     * (non-Javadoc)
     * @see net.jwsz.bew.portal.web.context.UserContext#getUserInfo()
     */
    @Override
    public UserInfo getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        return UserAuthUtil.getUserInfo(request, response);
    }

    /*
     * (non-Javadoc)
     * @see net.jwsz.bew.portal.web.context.UserContext#refreshUserInfo()
     */
    @Override
    public void refreshUserInfo(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub

    }

}
