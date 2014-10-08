/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.biz.service;

import java.util.List;

import com.codestudio.dorm.domain.Attachment;

/**
 * 类AttachmentService.java的实现描述：TODO 类实现描述
 * 
 * @author xlf 2013-8-21 上午9:40:27
 */
public interface AttachmentService {

    /**
     * 添加附件
     * 
     * @param attachment
     * @return 返回附件ID
     */
    public Long add(Attachment attachment);

    /**
     * 删除附件
     * 
     * @param attachmentId
     * @return
     */
    public boolean delete(long attachmentId);

    /**
     * 获取单个附件
     * 
     * @param attachmentId
     * @return
     */
    public Attachment getAttachment(long attachmentId);

    /**
     * 批量查询附件
     * 
     * @param attachmentIds
     * @return
     */
    public List<Attachment> getAttachments(long[] attachmentIds);

    /**
     * 根据UUID查询附件
     * 
     * @param uuid
     * @return
     * @author J 2014-7-9 下午10:01:07
     */
    public Attachment getAttachmentByUuid(String uuid);
}
