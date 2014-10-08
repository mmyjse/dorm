/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.form;

import com.codestudio.dorm.web.form.base.BaseForm;
import com.codestudio.dorm.web.form.base.FormError;

/**
 * 类LoginForm.java的实现描述：TODO 类实现描述
 * 
 * @author J 2013-7-23 下午11:21:27
 */
public class LoginForm extends BaseForm {

    private String loginId;

    private String password;

    private String validCode;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    /*
     * (non-Javadoc)
     * @see net.jwsz.bew.portal.web.form.base.BaseForm#validation()
     */
    @Override
    public FormError validation() {
        return null;
    }

    @Override
    public String toString() {
        return "LoginForm [loginId=" + loginId + ", password=" + password + ", validCode=" + validCode + "]";
    }

}
