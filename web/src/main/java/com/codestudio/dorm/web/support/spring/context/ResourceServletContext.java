/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.web.support.spring.context;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;


/**
 * 类ResourceServletContext.java的实现描述：TODO 类实现描述 
 * @author mmy 2014年5月1日 上午6:49:33
 */
public class ResourceServletContext implements ServletContextAware {

    public static final String RESOURCE_ROOT = "resourceRoot";
    private ServletContext     servletContext;
    private String             resourceRoot;
    private String             version       = "1.0";

    public void init() {
        resourceRoot += "-" + version;
        servletContext.setAttribute(RESOURCE_ROOT, getContextPath() + resourceRoot);
    }

    private String getContextPath() {
        String path = servletContext.getContextPath().replaceFirst("/", "");
        if (path != null && path.length() > 0) {
            // return path + "/";
            return "";
        } else {
            return "";
        }
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.web.context.ServletContextAware#setServletContext(javax.servlet.ServletContext)
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public String getResourceRoot() {
        return resourceRoot;
    }

    public void setResourceRoot(String resourceRoot) {
        this.resourceRoot = resourceRoot;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
