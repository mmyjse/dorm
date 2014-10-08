/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 类User.java的实现描述：用户/操作员
 * 
 * @author J 2014-5-13 下午9:12:08
 */
public class User implements Serializable {

    private static final long serialVersionUID = -7458992249440639235L;

    private Long              id;
    private String            workNumber;                              // 员工号
    private String            userName;                                // 员工姓名，冗余
    private UserType          userType;                                // 用户类型
    private String            loginName;                               // 登录帐号
    private String            password;                                // 登录密码
    private Date              createDate;                              // 创建时间
    private Date              updateDate;                              // 修改时间
    private Date              loginDate;                               // 最后登入时间
    private List<Role>        roles;                                   // 角色

    public User(){

    }

    /**
     * @param id
     */
    public User(Long id){
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", workNumber=" + workNumber + ", userName=" + userName + ", userType=" + userType
               + ", loginName=" + loginName + ", password=" + password + ", createDate=" + createDate + ", updateDate="
               + updateDate + ", loginDate=" + loginDate + ", roles=" + roles + "]";
    }

}
