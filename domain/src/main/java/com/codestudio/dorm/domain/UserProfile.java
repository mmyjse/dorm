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
 * 类UserProfile.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-5-18 上午4:09:25
 */
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 7002616685930219400L;

    private Long              id;
    private User              user;                                   // 所属用户
    private String            workNumber;                             // 员工工号
    private String            name;                                   // 员工姓名
    private String            mobile;                                 // 联系手机
    private String            telephone;                              // 联系电话
    private String            address;                                // 员工住址
    private String            qq;                                     // 联系QQ
    private String            wangwang;                               // 联系旺旺
    private String            wechat;                                 // 联系微信
    private String            fetion;                                 // 联系飞信
    private String            urgentName;                             // 紧急联系人
    private String            urgentMobile;                           // 紧急联系手机
    private String            urgentTelephone;                        // 紧急联系电话
    private String            urgentAddress;                          // 紧急联系地址
    private Sex               sex;                                    // 性别
    private Date              birthday;                               // 生日
    private String            idcard;                                 // 身份证号
    private String            idcardAddress;                          // 身份证地址
    private String            cardNumber;                             // 工资卡号
    private Date              createDate;                             // 创建时间
    private Date              updateDate;                             // 修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getUrgentName() {
        return urgentName;
    }

    public void setUrgentName(String urgentName) {
        this.urgentName = urgentName;
    }

    public String getUrgentMobile() {
        return urgentMobile;
    }

    public void setUrgentMobile(String urgentMobile) {
        this.urgentMobile = urgentMobile;
    }

    public String getUrgentTelephone() {
        return urgentTelephone;
    }

    public void setUrgentTelephone(String urgentTelephone) {
        this.urgentTelephone = urgentTelephone;
    }

    public String getUrgentAddress() {
        return urgentAddress;
    }

    public void setUrgentAddress(String urgentAddress) {
        this.urgentAddress = urgentAddress;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIdcardAddress() {
        return idcardAddress;
    }

    public void setIdcardAddress(String idcardAddress) {
        this.idcardAddress = idcardAddress;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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

    @Override
    public String toString() {
        return "UserProfile [id=" + id + ", user=" + user + ", workNumber=" + workNumber + ", name=" + name
               + ", mobile=" + mobile + ", telephone=" + telephone + ", address=" + address + ", qq=" + qq
               + ", wangwang=" + wangwang + ", wechat=" + wechat + ", fetion=" + fetion + ", urgentName=" + urgentName
               + ", urgentMobile=" + urgentMobile + ", urgentTelephone=" + urgentTelephone + ", urgentAddress="
               + urgentAddress + ", sex=" + sex + ", birthday=" + birthday + ", idcard=" + idcard + ", idcardAddress="
               + idcardAddress + ", cardNumber=" + cardNumber + ", createDate=" + createDate + ", updateDate="
               + updateDate + "]";
    }

}
