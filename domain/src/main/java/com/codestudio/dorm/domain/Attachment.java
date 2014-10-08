/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 类Attachment.java的实现描述：附件
 * 
 * @author J 2013-4-8 上午9:54:29
 */
public class Attachment implements Serializable {

    private static final long serialVersionUID = 6386656517569405682L;
    private Long              id;
    private String            uuid;                                    // 唯一ID
    private Long              userId;                                 // 用户ID
    private String            srcName;                                // 附件源始名称
    private String            descName;                               // 附件存储目标名称
    private String            path;                                   // 服务器存放路径
    private Long              size;                                   // 文件大小
    private String            ext;                                    // 文件扩展名
    private String            fileType;                               // 附件所属模块类型
    private Date              gmtCreate;                              // 上传时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public String getDescName() {
        return descName;
    }

    public void setDescName(String descName) {
        this.descName = descName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Attachment [id=" + id + ", uuid=" + uuid + ", userId=" + userId + ", srcName=" + srcName
               + ", descName=" + descName + ", path=" + path + ", size=" + size + ", ext=" + ext + ", fileType="
               + fileType + ", gmtCreate=" + gmtCreate + "]";
    }

}
