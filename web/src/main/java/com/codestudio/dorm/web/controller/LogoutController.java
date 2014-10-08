/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codestudio.dorm.web.context.UserContext;

/**
 * 类LogoutController.java的实现描述：用户退出系统
 * 
 * @author J 2013-7-23 下午11:13:44
 */
@Controller
public class LogoutController {

    private static final String PAGE_LOGIN = "login";

    @Autowired
    private UserContext         userContext;

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityUtils.getSubject().logout();
        userContext.doLogout(request, response);
        return "redirect:/" + PAGE_LOGIN;
    }

}
