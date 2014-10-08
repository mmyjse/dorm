/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.web.util;

/**
 * 类ResponseValue.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-9-15 下午9:30:36
 */
public class ResponseValue {

    public static final String SUCCESS = "200";
    public static final String ERROR   = "500";
    private boolean            success = Boolean.TRUE;
    private String             status  = SUCCESS;
    private Object             data;
    private String             errorCode;
    private String             errorMsg;

    /**
     * 
     */
    public ResponseValue(){
        super();
    }

    /**
     * @param status
     * @param data
     * @param errorCode
     * @param errorMsg
     */
    public ResponseValue(String status, Object data, String errorCode, String errorMsg){
        super();
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "ResponseValue [success=" + success + ", status=" + status + ", data=" + data + ", errorCode="
               + errorCode + ", errorMsg=" + errorMsg + "]";
    }

}
