/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.controller.functions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codestudio.dorm.biz.service.FunctionsService;
import com.codestudio.dorm.domain.Functions;
import com.codestudio.dorm.web.util.UserAuthUtil;

/**
 * 类PickupController.java的实现描述：叫件单控制器
 * 
 * @author J 2014-5-14 下午11:33:02
 */
@Controller
@RequestMapping("/functions/")
public class FunctionsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionsController.class);

    @Autowired
    private FunctionsService    functionsService;

    /**
     * 获取父级菜单
     * 
     * @param request
     * @param response
     * @return
     * @author J 2014-5-30 上午12:36:41
     */
    @ResponseBody
    @RequestMapping(value = "getFirstFunctions", method = { RequestMethod.GET, RequestMethod.POST })
    public List<Functions> getParentFunctions(HttpServletRequest request, HttpServletResponse response) {
        Long userId = UserAuthUtil.getUserId(request, response);
        return functionsService.getFunctionsByUserId(userId, 0L);
    }

    /**
     * 获取子级菜单
     * 
     * @param request
     * @param response
     * @return
     * @author J 2014-5-30 上午12:36:41
     */
    @ResponseBody
    @RequestMapping(value = "getSecondFunctions", method = { RequestMethod.GET, RequestMethod.POST })
    public List<Functions> getSecondFunctions(@RequestParam("parentId") Long parentId, HttpServletRequest request,
                                              HttpServletResponse response) {
        Long userId = UserAuthUtil.getUserId(request, response);
        return functionsService.getFunctionsByUserId(userId, parentId);
    }

}
