/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.biz.exception;

/**
 * 类DataErrorException.java的实现描述：数据错误异常
 * 
 * @author J 2014-9-15 下午9:21:51
 */
public class DataErrorException extends RuntimeException {

    private static final long  serialVersionUID       = -6419392466279679139L;

    public static final String CODE_BILLNUMBER_EXISTS = "D001";               // 快递单号已存在
    private String             errorCode;
    private String             errorMsg;

    /**
     * @param errorCode
     * @param errorMsg
     */
    public DataErrorException(String errorCode, String errorMsg){
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
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
        return "DataErrorException [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
    }

}
