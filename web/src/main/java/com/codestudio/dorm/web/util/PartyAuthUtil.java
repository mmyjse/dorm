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

import com.codestudio.dorm.common.cookie.UserCookieManager;
import com.codestudio.dorm.domain.Party;

/**
 * 类PartyAuthUtil.java的实现描述：会员授权工具
 * 
 * @author J 2014-6-7 上午11:20:12
 */
public class PartyAuthUtil {

    /**
     * 取得当前登录用户信息，未登录返回null
     * 
     * @param request
     * @param response
     * @return
     */
    public static Party getPartyInfo(HttpServletRequest request, HttpServletResponse response) {
        Party party = null;
        UserCookieManager userCookieManager = new UserCookieManager(request, response, null, "/");
        String partyId = userCookieManager.getTempCookie(UserCookieManager.PARTY_ID, null);
        if (StringUtils.isNotBlank(partyId)) {
            party = new Party();
            party.setId(Long.valueOf(partyId));
            party.setPartyNum(userCookieManager.getTempCookie(UserCookieManager.PARTY_NUM, null));
        }
        return party;
    }

    /**
     * 取得当前登录用户标识，未登录返回null
     * 
     * @param request
     * @param response
     * @return
     */
    public static Long getPartyId(HttpServletRequest request, HttpServletResponse response) {
        UserCookieManager userCookieManager = new UserCookieManager(request, response, null, "/");
        String partyId = userCookieManager.getTempCookie(UserCookieManager.PARTY_ID, null);
        if (StringUtils.isNotBlank(partyId)) {
            return Long.valueOf(partyId);
        }
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
        String partyId = userCookieManager.getTempCookie(UserCookieManager.PARTY_ID, null);
        return StringUtils.isNotBlank(partyId);
    }

    /**
     * 登录，写cookie
     * 
     * @param userInfo
     * @param request
     * @param response
     */
    public static void signIn(Party party, HttpServletRequest request, HttpServletResponse response) {
        if (party != null) {
            UserCookieManager userCookieManager = new UserCookieManager(request, response, null, "/");
            userCookieManager.setTempCookie(UserCookieManager.PARTY_ID, "" + party.getId());
            userCookieManager.setTempCookie(UserCookieManager.PARTY_NUM, party.getPartyNum());
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
        userCookieManager.setTempCookie(UserCookieManager.PARTY_ID, null);
        userCookieManager.removeTempCookie(UserCookieManager.PARTY_ID);
        userCookieManager.setTempCookie(UserCookieManager.PARTY_NUM, null);
        userCookieManager.removeTempCookie(UserCookieManager.PARTY_NUM);
        userCookieManager.saveTempCookie();
    }
}
