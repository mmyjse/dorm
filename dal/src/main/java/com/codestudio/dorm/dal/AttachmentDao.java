/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.dal;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.codestudio.dorm.dal.base.BaseDao;
import com.codestudio.dorm.domain.Attachment;

/**
 * 类AttachmentDao.java的实现描述：附件
 * 
 * @author xlf 2013-8-21 上午9:36:22
 */
public interface AttachmentDao extends BaseDao<Attachment, Map<String, Object>> {

    /**
     * 批量获取附件
     * 
     * @param attachmentIds
     * @return
     */
    public List<Attachment> findByIds(long[] attachmentIds);

    /**
     * 根据UUID查询附件
     * 
     * @param uuid
     * @return
     * @author J 2014-7-8 下午9:54:08
     */
    public Attachment getByUuid(@Param("uuid") String uuid);
}
