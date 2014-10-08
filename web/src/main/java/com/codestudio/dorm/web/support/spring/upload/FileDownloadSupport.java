/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.support.spring.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * 类DownloadSuppot.java的实现描述：下载附件
 * 
 * @author tcf 2013-5-16 上午10:02:21
 */
public class FileDownloadSupport {

    private String downloadPath;

    /**
     * 下载附件
     * 
     * @param path 附件路径
     * @param srcName 附件名
     * @param response
     * @return
     */
    public boolean download(String path, String srcName, HttpServletResponse response) {
        try {
            if (!"".equals(path)) {
                path = downloadPath + path;
                File file = new File(path);
                if (file.exists()) {
                    InputStream ins = new FileInputStream(path);
                    BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面
                    OutputStream outs = response.getOutputStream();// 获取文件输出IO流
                    BufferedOutputStream bouts = new BufferedOutputStream(outs);
                    response.setContentType("application/x-download");// 设置response内容的类型
                    response.setHeader("Content-disposition",
                                       "attachment;filename=" + URLEncoder.encode(srcName, "UTF-8"));// 设置头部信息
                    response.setCharacterEncoding("UTF-8");
                    response.flushBuffer();
                    // response.flushBuffer();
                    int bytesRead = 0;
                    byte[] buffer = new byte[8192];
                    // 开始向网络传输文件流
                    while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                        bouts.write(buffer, 0, bytesRead);
                    }
                    bouts.flush();// 这里一定要调用flush()方法
                    ins.close();
                    bins.close();
                    outs.close();
                    bouts.close();
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }
            } else {
                return Boolean.FALSE;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

}
