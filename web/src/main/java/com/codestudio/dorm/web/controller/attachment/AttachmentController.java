/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.controller.attachment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.codestudio.dorm.biz.service.AttachmentService;
import com.codestudio.dorm.common.encrypt.Base64;
import com.codestudio.dorm.domain.Attachment;
import com.codestudio.dorm.web.support.spring.upload.FileUploadSupport;
import com.codestudio.dorm.web.util.UserAuthUtil;

/**
 * 类AttachmentController.java的实现描述：附件上传
 * 
 * @author J 2013-4-8 下午2:47:33
 */
@Controller
@RequestMapping("/attachment/")
public class AttachmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttachmentController.class);

    @Autowired
    private FileUploadSupport   fileUploadSupport;

    @Autowired
    private AttachmentService   attachmentService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "uploadByte")
    public Long uploadByte(@RequestParam(value = "fileType", required = false) String fileType, String attachment,
                           String uuid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] image = Base64.decode(attachment.substring(22));
        try {
            Long userId = UserAuthUtil.getUserId(request, response);
            Attachment _attachment = fileUploadSupport.upload(userId, image, fileType, uuid);

            if (_attachment != null) {
                // model.addAttribute("attachment", _attachment);
                return _attachment.getId();
            } else {
                // model.addAttribute("error", "上传失败");
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("上传附件失败", e);
            // model.addAttribute("error", "上传失败：" + e.getMessage());
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "upload")
    public Model upload(@RequestParam(value = "fileType", required = false) String fileType, MultipartFile attachment,
                        Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Long userId = UserAuthUtil.getUserId(request, response);
            Attachment _attachment = fileUploadSupport.upload(userId, attachment, fileType);

            if (_attachment != null) {
                model.addAttribute("attachment", _attachment);
                return model;
            } else {
                model.addAttribute("error", "上传失败");
                return model;
            }
        } catch (Exception e) {
            LOGGER.error("上传附件失败", e);
            model.addAttribute("error", "上传失败：" + e.getMessage());
            return model;
        }
    }

    @RequestMapping(value = "getImgage", method = { RequestMethod.GET, RequestMethod.POST })
    public void getImgage(@Param("attachmentId") long attachmentId, HttpServletResponse response) {
        Attachment attachment = attachmentService.getAttachment(attachmentId);
        if (attachment == null) {
            return;
        }
        String path = attachment.getPath() + attachment.getDescName() + attachment.getExt();
        path = fileUploadSupport.getUploadFilePath() + path;
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        try {
            InputStream ins = new FileInputStream(path);
            BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面
            OutputStream outs = response.getOutputStream();// 获取文件输出IO流
            BufferedOutputStream bouts = new BufferedOutputStream(outs);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            // 开始向网络传输文件流
            while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                bouts.write(buffer, 0, bytesRead);
            }
            bouts.flush();
            ins.close();
            bins.close();
            outs.close();
            bouts.close();
        } catch (Exception e) {
            LOGGER.error("输出图片出错", e);
        }
    }

}
