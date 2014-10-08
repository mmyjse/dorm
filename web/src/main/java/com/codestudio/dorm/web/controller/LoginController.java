package com.codestudio.dorm.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codestudio.dorm.biz.service.UserService;
import com.codestudio.dorm.web.context.UserContext;
import com.codestudio.dorm.web.form.LoginForm;
import com.codestudio.dorm.web.util.UserAuthUtil;

/**
 * 类LoginController.java的实现描述：前台用户登录
 * 
 * @author J 2013-7-23 下午11:14:54
 */
@Controller
public class LoginController {

    private static final Logger logger     = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService         userService;

    @Autowired
    private UserContext         userContext;

    private static final String PAGE_LOGIN = "login";
    private static final String PAGE_INDEX = "index";

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(@ModelAttribute("loginForm") LoginForm loginForm, HttpServletRequest request,
                        HttpServletResponse response) {
        if (UserAuthUtil.isSignIn(request, response)) {
            return "redirect:/" + PAGE_INDEX;
        }
        HttpSession session = request.getSession();
        session.removeAttribute("randCheckCode");
        return PAGE_LOGIN;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String doLogin(@ModelAttribute("userForm") LoginForm userForm, Model model, HttpServletRequest request,
                          HttpServletResponse response) {

        if (UserAuthUtil.isSignIn(request, response)) {
            return "redirect:/" + PAGE_INDEX;
        }
        // HttpSession session = request.getSession();
        // String validCode = userForm.getValidCode();
        // String code = (String) session.getAttribute("randCheckCode");
        // if (validCode == null || !validCode.equalsIgnoreCase(code)) {
        // session.removeAttribute("randCheckCode");
        // model.addAttribute("iscode", false);
        // return PAGE_LOGIN;
        // }

        // ResponseResult responseResult = userContext.doLogin(userForm.getLoginId(), userForm.getPassword(),
        // userForm.getValidCode(), request, response);
        // if (responseResult == null || !responseResult.isSuccess()) {
        // model.addAttribute("hasError", true);
        // return PAGE_LOGIN;
        // }

        UsernamePasswordToken token = new UsernamePasswordToken(userForm.getLoginId(), userForm.getPassword());
        try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            logger.debug("Error authenticating.", e);
            model.addAttribute("hasError", true);
            return PAGE_LOGIN;
        }
        return "redirect:/";// + PAGE_INDEX;
    }

}
