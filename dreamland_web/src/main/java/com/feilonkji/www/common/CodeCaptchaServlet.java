package com.feilonkji.www.common;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @title: CodeCaptchaServlet
 * @Description: 验证码生成类
 * @Author zr
 * @Date:2020/9/25 18:21
 * @Version 1.8
 */
public class CodeCaptchaServlet extends HttpServlet {

    private static final long serialVersionUID = 5413310437308046316L;
    public static final String VERCODE_KEY = "VERCODE_KEY";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //移除上一次存入的属性
        req.getSession().removeAttribute(VERCODE_KEY);
        //设置页面不缓存
        resp.setHeader("Pragma","No-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires",0);

        //在内存中创建图像
        int imgWidth = 55;
        int imgHeight = 18;
        //新建图像缓冲区
        BufferedImage image = new BufferedImage(imgWidth,imgHeight,BufferedImage.TYPE_INT_RGB);
        //获取图形上下文
        Graphics g = image.getGraphics();
        //设置背景色
        g.setColor(Color.white);
        g.fillRect(0,0,imgWidth,imgHeight);
        //画边框
        g.setColor(Color.black);
        g.drawRect(0,0,imgWidth - 1,imgHeight - 1);
        //随机产生4位验证码
        int intCount = 0;
        intCount = new Random().nextInt(9999);
        if(intCount < 1000 ){
            intCount += 1000;
        }
        String rand = String.valueOf(intCount);
        //将认证码显示到图像中
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman",Font.PLAIN,18));
        g.drawString(rand,5,15);
        //随机产生88个干扰点，使得图像中的认证码不易被其他程序探测到
        Random random = new Random();
        for(int i = 0;i < 100;i++){
            int x = random.nextInt(imgWidth);
            int y = random.nextInt(imgHeight);
            g.drawLine(x,y,x,y);
        }
        //将生成的随机字符串写入session
        req.getSession().setAttribute(VERCODE_KEY,rand);
        //图像生效
        g.dispose();
        //输出图像到页面
        ImageIO.write(image,"JPEG",resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
