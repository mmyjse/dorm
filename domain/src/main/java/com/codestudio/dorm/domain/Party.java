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

/**
 * 类Party.java的实现描述：会员
 * 
 * @author J 2014-5-13 下午8:33:48
 */
public class Party implements Serializable {

    private static final long  serialVersionUID   = -6076523544965950490L;

    public static final String PARTY_LEVEL_NORMAL = "normal";
    public static final String PARTY_LEVEL_VIP    = "vip";
    private Long               id;
    private String             partyNum;                                  // 会员号
    private String             password;                                  // 密码
    private String             partyLevel;                                // 会员级别
    private String             partyName;                                 // 会员名称
    private String             mobile;                                    // 联系手机
    private String             telephone;                                 // 联系电话
    private String             qq;                                        // 联系QQ
    private String             wangwang;                                  // 联系旺旺
    private String             wechat;                                    // 联系微信
    private String             fetion;                                    // 联系飞信
    private Boolean            enable;                                    // 是否可用
    private Date               createDate;                                // 创建时间

    public Party(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartyNum() {
        return partyNum;
    }

    public void setPartyNum(String partyNum) {
        this.partyNum = partyNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPartyLevel() {
        return partyLevel;
    }

    public void setPartyLevel(String partyLevel) {
        this.partyLevel = partyLevel;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWangwang() {
        return wangwang;
    }

    public void setWangwang(String wangwang) {
        this.wangwang = wangwang;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getFetion() {
        return fetion;
    }

    public void setFetion(String fetion) {
        this.fetion = fetion;
    }

    public Boolean isEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Party [id=" + id + ", partyNum=" + partyNum + ", password=" + password + ", partyLevel=" + partyLevel
               + ", partyName=" + partyName + ", mobile=" + mobile + ", telephone=" + telephone + ", qq=" + qq
               + ", wangwang=" + wangwang + ", wechat=" + wechat + ", fetion=" + fetion + ", enable=" + enable
               + ", createDate=" + createDate + "]";
    }

}
