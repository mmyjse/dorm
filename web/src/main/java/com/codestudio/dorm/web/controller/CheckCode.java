/*
 * Copyright 2013 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类CheckCode.java的实现描述：TODO 类实现描述 
 * @author tcf 2013-9-26 上午9:28:20
 */
@Controller
public class CheckCode extends HttpServlet {
    public CheckCode(){
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void init() throws ServletException {
        super.init();
    }

    public Color getRandColor(int s, int e) {
        Random random = new Random();
        if (s > 255) s = 255;
        if (e > 255) e = 255;
        int r = s + random.nextInt(e - s);
        int g = s + random.nextInt(e - s);
        int b = s + random.nextInt(e - s);
        return new Color(r, g, b);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCodeImg")
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        // 指定生成的响应是图片
        response.setContentType("image/jpeg");
        int width = 80;
        int height = 32;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // 创建BufferedImage类的对象
        Graphics g = image.getGraphics(); // 创建Graphics类的对象
        Random random = new Random(); // 实例化一个Random对象
        Font mFont = new Font("华文宋体", Font.BOLD, 20); // 通过Font构造字体
        g.setColor(getRandColor(200, 250)); // 改变图形的当前颜色为随机生成的颜色
        g.fillRect(0, 0, width, height); // 绘制一个填色矩形

        // 生成并输出随机的验证文字
        g.setFont(mFont);
        String sRand = "";
        int itmp = 0;
        for (int i = 0; i < 4; i++) {
            itmp = random.nextInt(10) + 48; // 生成0~9的数字
            char ctmp = (char) itmp;
            sRand += String.valueOf(ctmp);
            Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110));
            g.setColor(color);
            /**** 随机缩放文字并将文字旋转指定角度 **/
            // 将文字旋转指定角度
            Graphics2D g2d_word = (Graphics2D) g;
            AffineTransform trans = new AffineTransform();
            trans.rotate(random.nextInt(45) * 3.14 / 180, 15 * i + 10, 7);
            // 缩放文字
            float scaleSize = random.nextFloat() + 0.8f;
            if (scaleSize > 1.1f) scaleSize = 1f;
            trans.scale(scaleSize, scaleSize);
            g2d_word.setTransform(trans);
            /************************/
            g.drawString(String.valueOf(ctmp), 15 * i + 20, 16);

        }
        // 将生成的验证码保存到Session中
        HttpSession session = request.getSession(true);
        session.setAttribute("randCheckCode", sRand);
        g.dispose();
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

}
