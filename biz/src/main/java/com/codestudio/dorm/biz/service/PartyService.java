/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.biz.service;

import com.codestudio.dorm.common.exception.DataAlreadyExistsException;
import com.codestudio.dorm.domain.Party;

/**
 * 类PartyService.java的实现描述：会员服务
 * 
 * @author J 2014-5-14 上午12:19:18
 */
public interface PartyService {

    /**
     * 根据会员号查询会员信息
     * 
     * @param partyNum 会员号
     * @param isLoadAddress 是否加载会员地址信息
     * @return
     * @author J 2014-5-14 上午12:35:00
     */
    public Party getPartyByPartyNum(String partyNum, boolean isLoadAddress);

    /**
     * 创建会员
     * 
     * @param party
     * @return
     * @throws DataAlreadyExistsException
     * @author J 2014-6-5 下午9:12:40
     */
    public Party addParty(Party party) throws DataAlreadyExistsException;

    /**
     * 验证会员登录
     * 
     * @param partyNum
     * @param password
     * @return
     * @author J 2014-6-6 下午8:53:53
     */
    public Party validLogin(String partyNum, String password);
}
