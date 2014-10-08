/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.web.security.shiro;

import java.util.List;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.codestudio.dorm.biz.service.FunctionsService;
import com.codestudio.dorm.biz.service.UserService;
import com.codestudio.dorm.domain.User;

/**
 * 类ShiroDataBaseRealm.java的实现描述：TODO 类实现描述
 * 
 * @author mmy 2014年5月1日 上午6:47:38
 */
public class ShiroDataBaseRealm extends AuthorizingRealm {

    @Autowired
    private FunctionsService functionsService;

    @Autowired
    private UserService      userService;

    /*
     * (non-Javadoc)
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("Principal对象不能为空");
        }

        User user = (User) principals.fromRealm(getName()).iterator().next();

        // 获取用户响应的permission
        List<String> permissions = getPermissionsByUser(user.getId());// CollectionUtils.extractToList(user.getResourcesList(),
                                                                      // "permission", true);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addStringPermissions(permissions);

        return info;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();

        if (username == null) {
            throw new AccountException("用户名不能为空");
        }

        User user = userService.getUserByWorkNumber(username, true);

        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }

        // if (!user.isEnable()) {
        // throw new AccountException("用户名已禁用");
        // }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

    private List<String> getPermissionsByUser(long userId) {
        // List<String> perms = new ArrayList<String>();
        //
        // List<Functions> funcs = functionsService.getFunctionsByUserId(userId, null);
        // for (Functions func : funcs) {
        // if (StringUtils.isNotBlank(func.getPermission())) {
        // perms.add(func.getPermission());
        // }
        // }
        // return perms;
        return null;
    }
}
