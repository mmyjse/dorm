package com.codestudio.dorm.common.exception;

/**
 * 类UserAlreadyExistsException.java的实现描述：用户已经存在异常
 * 
 * @author mmyjse@gmail.com 2012-7-29 下午7:36:13
 */
public class DataAlreadyExistsException extends Exception {

    private static final long  serialVersionUID     = 9182617820256703047L;

    public static final String ERROR_CODE_PARTY_NUM = "party_num_already_exists";
    private String             errorCode;

    public DataAlreadyExistsException(){
    }

    public DataAlreadyExistsException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public DataAlreadyExistsException(String message){
        super(message);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
