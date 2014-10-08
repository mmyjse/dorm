/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.codestudio.dorm.biz.service.AttachmentService;
import com.codestudio.dorm.dal.AttachmentDao;
import com.codestudio.dorm.domain.Attachment;

/**
 * 类AttachmentServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author xlf 2013-8-21 上午10:04:23
 */
@Service("attachmentService")
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentDao attachmentDao;

    /*
     * (non-Javadoc)
     * @see net.jwsz.bew.biz.service.AttachmentService#add(net.jwsz.bew.domain.Attachment)
     */
    @Override
    public Long add(Attachment attachment) {
        Assert.notNull(attachment);
        attachmentDao.create(attachment);
        return attachment.getId();
    }

    /*
     * (non-Javadoc)
     * @see net.jwsz.bew.biz.service.AttachmentService#delete(long)
     */
    @Override
    public boolean delete(long attachmentId) {
        Assert.isTrue(attachmentId > 0);
        return attachmentDao.delete(attachmentId) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /*
     * (non-Javadoc)
     * @see net.jwsz.bew.biz.service.AttachmentService#getAttachment(long)
     */
    @Override
    public Attachment getAttachment(long attachmentId) {
        Assert.isTrue(attachmentId > 0);
        return attachmentDao.get(attachmentId);
    }

    /*
     * (non-Javadoc)
     * @see net.jwsz.bew.biz.service.AttachmentService#getAttachments(long[])
     */
    @Override
    public List<Attachment> getAttachments(long[] attachmentIds) {
        Assert.isTrue(attachmentIds.length > 0);
        return attachmentDao.findByIds(attachmentIds);
    }

    /*
     * (non-Javadoc)
     * @see com.diqitian.ed.biz.service.AttachmentService#getAttachmentByUuid(java.lang.String)
     */
    @Override
    public Attachment getAttachmentByUuid(String uuid) {
        return attachmentDao.getByUuid(uuid);
    }

}
