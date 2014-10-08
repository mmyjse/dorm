/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.web.security.shiro;

import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;


/**
 * 类ChainDefinitionSectionMetaSource.java的实现描述：TODO 类实现描述 
 * @author mmy 2014年5月1日 上午6:46:08
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

    private static final Logger LOGGER            = LoggerFactory.getLogger(ChainDefinitionSectionMetaSource.class);

    private String              filterChainDefinitions;

    /**
     * 默认premission字符串
     */
    public static final String  PREMISSION_STRING = "perms[\"{0}\"]";

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#getObject()
     */
    @Override
    public Section getObject() throws Exception {
        // 获取所有资源
        Ini ini = new Ini();
        // 加载默认的url
        ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        return section;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#getObjectType()
     */
    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#isSingleton()
     */
    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }
}
