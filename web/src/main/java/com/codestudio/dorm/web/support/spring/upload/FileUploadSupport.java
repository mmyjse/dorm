/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.support.spring.upload;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.codestudio.dorm.biz.service.AttachmentService;
import com.codestudio.dorm.common.util.DateUtils;
import com.codestudio.dorm.domain.Attachment;

/**
 * 类FileUploadHelper.java的实现描述：文件上传工具类
 * 
 * @author J 2013-4-8 下午3:47:11
 */
public class FileUploadSupport {

    private static final Logger logger       = LoggerFactory.getLogger(FileUploadSupport.class);

    private String              uploadFilePath;

    @Autowired
    AttachmentService           attachmentService;

    private static final String DEFAULT_TYPE = "default";

    public Attachment upload(long userId, byte[] file, String type, String uuid) {
        if (StringUtils.isBlank(type)) {
            type = DEFAULT_TYPE;
        }
        if (file == null) {
            return null;
        }

        FileOutputStream fs = null;
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(file);

            String ext = ".png";
            Date now = new Date();
            String filePath = "/" + type + "/"
                              + DateUtils.dateConvert2String(now, DateUtils.DATEPATTERN_YYYY_MM_DD4FILE) + "/";

            String fileName = now.getTime() + "" + ((int) (Math.random() * 10));

            File f = new File(uploadFilePath + filePath);
            if (!f.exists()) {
                f.mkdirs();
            }
            fs = new FileOutputStream(uploadFilePath + filePath + fileName + ext);
            byte[] buffer = new byte[1024 * 1024];
            int byteread = 0;
            while ((byteread = is.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
                fs.flush();
            }

            // 附件上传成功后，需添加到数据库
            Attachment attachment = new Attachment();
            attachment.setSrcName(null);
            attachment.setDescName(fileName);
            attachment.setFileType(type);
            attachment.setExt(ext);
            attachment.setPath(filePath);
            attachment.setSize(file.length + 0L);
            attachment.setUserId(userId);
            attachment.setUuid(uuid);
            attachmentService.add(attachment);
            return attachment;
        } catch (Exception e) {
            logger.error("upload file error:", e);
        } finally {
            try {
                fs.close();
                is.close();
            } catch (Exception e) {
                logger.error("close file error:", e);
            }
        }
        return null;
    }

    /**
     * 上传文件
     * 
     * <pre>
     * 文件存放在默认目录下
     * </pre>
     * 
     * @param file
     * @return
     */
    public Attachment upload(long userId, MultipartFile file) {
        return this.upload(userId, file, DEFAULT_TYPE);
    }

    /**
     * 上传文件
     * 
     * @param file
     * @param type
     * @return
     */
    public Attachment upload(long userId, MultipartFile file, String type) {
        if (StringUtils.isBlank(type)) {
            type = DEFAULT_TYPE;
        }
        FileOutputStream fs = null;
        InputStream is = null;
        if (file == null) {
            return null;
        }
        try {
            is = file.getInputStream();
            String orgFileName = file.getOriginalFilename();
            int i = orgFileName.lastIndexOf('.');
            String ext = "";
            if (i > 0) {
                ext = orgFileName.substring(i);
            }
            Date now = new Date();
            String filePath = "/" + type + "/"
                              + DateUtils.dateConvert2String(now, DateUtils.DATEPATTERN_YYYY_MM_DD4FILE) + "/";

            String fileName = now.getTime() + "" + ((int) (Math.random() * 10));

            File f = new File(uploadFilePath + filePath);
            if (!f.exists()) {
                f.mkdirs();
            }
            fs = new FileOutputStream(uploadFilePath + filePath + fileName + ext);
            byte[] buffer = new byte[1024 * 1024];
            int byteread = 0;
            while ((byteread = is.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
                fs.flush();
            }

            // 附件上传成功后，需添加到数据库
            Attachment attachment = new Attachment();
            attachment.setSrcName(file.getOriginalFilename());
            attachment.setDescName(fileName);
            attachment.setFileType(type);
            attachment.setExt(ext);
            attachment.setPath(filePath);
            attachment.setSize(file.getSize());
            attachment.setUserId(userId);
            attachmentService.add(attachment);
            return attachment;
        } catch (Exception e) {
            logger.error("upload file error:", e);
        } finally {
            try {
                fs.close();
                is.close();
            } catch (Exception e) {
                logger.error("close file error:", e);
            }
        }
        return null;
    }

    /**
     * @return the uploadFilePath
     */
    public String getUploadFilePath() {
        return uploadFilePath;
    }

    /**
     * @param uploadFilePath the uploadFilePath to set
     */
    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }

}
