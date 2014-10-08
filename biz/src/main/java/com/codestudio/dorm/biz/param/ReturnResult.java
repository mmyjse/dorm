/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.biz.param;

/**
 * 类ReturnResult.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-6-30 下午11:47:59
 */
public class ReturnResult {

    private boolean success = Boolean.TRUE;
    private Object  data;
    private String  errorCode;
    private String  errorMsg;

    public ReturnResult(){
        super();
    }

    public ReturnResult(boolean success, Object data, String errorCode, String errorMsg){
        super();
        this.success = success;
        this.data = data;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ReturnResult [success=" + success + ", data=" + data + ", errorCode=" + errorCode + ", errorMsg="
               + errorMsg + "]";
    }

}
