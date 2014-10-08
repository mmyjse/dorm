package com.codestudio.dorm.common.cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户cookie管理类
 * 
 * @author J 2013-4-2 下午4:31:59
 */
public class UserCookieManager extends CookieManagerBase {

    private static final String COOKIE_ADMIN_TMP = "COOKIE_USER_TMP";

    public static final String  USER_ID          = "ID";
    public static final String  USER_LOGIN_NAME  = "LOGIN_NAME";
    public static final String  USER_NAME        = "NAME";
    public static final String  USER_TYPE        = "TYPE";
    public static final String  USER_WORK_NUMBER = "WORK_NUMBER";
    public static final String  LAST_LOGIN_TIME  = "T";

    public static final String  PARTY_ID         = "PARTY_ID";
    public static final String  PARTY_NUM        = "PARTY_NUM";

    public UserCookieManager(HttpServletRequest request, HttpServletResponse response, String domain, String path){
        super(request, response, domain, path);
    }

    public UserCookieManager(HttpServletRequest request){
        this(request, null, null, null);
    }

    /**
     * 获得临时cookie中的一个项值
     */
    public String getTempCookie(String key) {
        return getTempCookie(key, null);
    }

    /**
     * 获得临时cookie中的一个项值。若为空，则返回defaultValue
     */
    public String getTempCookie(String key, String defaultValue) {
        return getValue(COOKIE_ADMIN_TMP, key, defaultValue);
    }

    /**
     * 设置临时cookie的一个项值。若value为空，则相当于removeTempCookie
     */
    public void setTempCookie(String key, String value) {
        setValue(COOKIE_ADMIN_TMP, key, value);
    }

    /**
     * 删除一个临时cookie项
     */
    public void removeTempCookie(String key) {
        setValue(COOKIE_ADMIN_TMP, key, null);
    }

    /**
     * 保存临时cookie中所有的项，并且写入response
     */
    public void saveTempCookie() {
        save(COOKIE_ADMIN_TMP, TEMP_COOKIE_AGE);
    }

}
