/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.dal;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.codestudio.dorm.dal.base.BaseDao;
import com.codestudio.dorm.domain.Party;

/**
 * 类PartyDao.java的实现描述：会员DAO
 * 
 * @author mmy 2014-5-13 下午8:11:19
 */
public interface PartyDao extends BaseDao<Party, Map<String, Object>> {

    /**
     * 根据会员号获取会员信息
     * 
     * @param partyNum
     * @return
     * @author J 2014-5-14 上午12:58:16
     */
    public Party getPartyByPartyNum(@Param("partyNum") String partyNum);
}
