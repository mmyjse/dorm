/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.biz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.codestudio.dorm.biz.service.PartyService;
import com.codestudio.dorm.common.encrypt.CreateMD5;
import com.codestudio.dorm.common.exception.DataAlreadyExistsException;
import com.codestudio.dorm.dal.PartyDao;
import com.codestudio.dorm.domain.Party;

/**
 * 类PartyServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-5-14 上午12:42:24
 */
@Service
public class PartyServiceImpl implements PartyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartyServiceImpl.class);

    @Autowired
    private PartyDao            partyDao;

    /*
     * (non-Javadoc)
     * @see com.diqitian.ed.biz.service.PartyService#getPartyByPartyNum(java.lang.String, boolean)
     */
    @Override
    public Party getPartyByPartyNum(String partyNum, boolean isLoadAddress) {
        Assert.notNull(partyNum, "会员号不能为空");
        Party party = partyDao.getPartyByPartyNum(partyNum);
        if (party == null) {
            return null;
        }
        return party;
    }

    /*
     * (non-Javadoc)
     * @see com.diqitian.ed.biz.service.PartyService#addParty(com.diqitian.ed.domain.Party)
     */
    @Override
    public Party addParty(Party party) throws DataAlreadyExistsException {
        Assert.notNull(party.getPartyNum(), "会员号不能为空");
        Assert.notNull(party.getPassword(), "会员密码不能为空");
        Party partyDB = this.getPartyByPartyNum(party.getPartyNum(), false);
        if (partyDB != null) {
            LOGGER.error("会员号已经存在,party={}", party);
            throw new DataAlreadyExistsException(DataAlreadyExistsException.ERROR_CODE_PARTY_NUM);
        }
        party.setPassword(CreateMD5.createMD5(party.getPassword()));
        party.setEnable(true);
        if (party.getPartyLevel() == null) {
            party.setPartyLevel(Party.PARTY_LEVEL_NORMAL);
        }
        partyDao.create(party);
        return party;
    }

    /*
     * (non-Javadoc)
     * @see com.diqitian.ed.biz.service.PartyService#validLogin(java.lang.String, java.lang.String)
     */
    @Override
    public Party validLogin(String partyNum, String password) {
        Assert.notNull(partyNum, "会员号不能为空");
        Assert.notNull(password, "会员密码不能为空");
        Party party = this.getPartyByPartyNum(partyNum, false);
        if (party == null) {
            return null;
        }
        if (!party.getPassword().equals(CreateMD5.createMD5(password))) {
            return null;
        }
        return party;
    }
}
