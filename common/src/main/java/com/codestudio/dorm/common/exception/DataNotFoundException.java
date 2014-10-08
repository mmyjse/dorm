package com.codestudio.dorm.common.exception;

/**
 * 类DataNotFoundException.java的实现描述：数据未找到异常
 * 
 * @author mmyjse@gmail.com 2012-9-6 上午2:32:31
 */
public class DataNotFoundException extends Exception {

    private static final long  serialVersionUID = 1732166674481343905L;

    public static final String ERROR_CODE_USER  = "user_not_found";
    private String             errorCode;

    public DataNotFoundException(){
    }

    public DataNotFoundException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public DataNotFoundException(String message){
        super(message);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
