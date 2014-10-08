/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.web.form.base;

import java.io.Serializable;

/**
 * 类BaseForm.java的实现描述：表单基类
 * 
 * @author mmy 2014年5月1日 上午6:39:46
 */
public abstract class BaseForm implements Serializable {

    private static final long serialVersionUID = 342957865132033831L;

    /**
     * 验证表单
     * 
     * @return
     */
    public abstract FormError validation();
}
