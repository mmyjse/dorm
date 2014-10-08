/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.context;

import java.util.Date;

import com.codestudio.dorm.domain.UserType;

/**
 * 类UserInfo.java的实现描述：TODO 类实现描述
 * 
 * @author J 2013-7-24 上午2:50:35
 */
public class UserInfo {

    private long     id;
    private String   name;
    private String   loginName; // 登录帐号
    private String   workNumber; // 员工号
    private UserType userType;  // 用户类型
    private Date     loginDate; // 最后登入时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "UserInfo [id=" + id + ", name=" + name + ", loginName=" + loginName + ", workNumber=" + workNumber
               + ", userType=" + userType + ", loginDate=" + loginDate + "]";
    }

}
