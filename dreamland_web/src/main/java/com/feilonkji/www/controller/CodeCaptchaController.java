package com.feilonkji.www.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

/**
 * @title: CodeCaptchaController
 * @Description: 验证码处理类
 * @Author zr
 * @Date:2020/9/27 9:16
 * @Version 1.8
 */
@Controller
public class CodeCaptchaController {

    /**验证码的key值*/
    public static final String CODE_SIGN = "codeKey";

    /**验证码默认值*/
    private static final String DEFAULT_NUMBER = "1234";

    /**日志对象*/
    private static Logger LOG = Logger.getLogger(CodeCaptchaController.class);



    /**
     *
     * Description: 处理生成验证码请求
     * @param request
     * @param response
     * @return java.lang.String
     * @throws
     * @date 2020/9/27
     */
    @RequestMapping(value = "/codeCaptcha")
    public void createCodeCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //移除存放的验证码
        request.getSession().removeAttribute(CODE_SIGN);
        //创建图像缓冲区
        int width = 60;
        int height = 20;
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics graphics = bufferedImage.getGraphics();
        //设置画笔颜色画背景色
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,width,height);
        //画边框
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0,0,width - 1,height - 1);
        //获取随机数
        String randomStr = getRandomString();
        //将验证码画入图像缓冲区
        graphics.setFont(new Font("Times New Roman",Font.PLAIN,18));
        graphics.drawString(randomStr,5,15);
        //产生干扰线条
        createDisturbLine(graphics,width,height);
        //将随机码存入session
        request.getSession().setAttribute(CODE_SIGN,randomStr);
        //关闭资源
        graphics.dispose();
        LOG.debug("验证码randomStr ==> " + randomStr);
        //将图片缓存返回
        ImageIO.write(bufferedImage,"JPEG",response.getOutputStream());

    }

    /**
     *
     * Description: 产生干扰线条
     * @param graphics 环境画笔
     * @param width 图像宽
     * @param height 高
     * @return void
     * @throws
     * @date 2020/9/27
     */
    private void createDisturbLine(Graphics graphics,int width,int height) {
        //产生40个干扰线条
        int number = 10;
        int count = 2;
        Random random = new Random();
        for(int a=0;a<number;a++){
            int[][] temp = new int[2][2];
            for(int i=0;i<count;i++){
                temp[0][i] = random.nextInt(width);
                temp[1][i] = random.nextInt(height);
            }
            graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            //产生干扰线条
            graphics.drawLine(temp[0][0],temp[1][0],temp[0][1] + random.nextInt(width),temp[1][1] + random.nextInt(height));
        }
    }

    /**
     *
     * Description: 生成随机字符串
     * @param
     * @return java.lang.String
     * @throws
     * @date 2020/9/27
     */
    private String getRandomString() {
        Random random = new Random();
        StringBuffer str = new StringBuffer();
        int num = 4;
        for(int i=0;i<num;i++){
            int randomInt = random.nextInt(3);
            switch (randomInt){
                case 0:{
                    //产生数字
                    int numberOne = random.nextInt(10);
                    str.append(numberOne);
                    break;
                }
                case 1:{
                    //产生小写字母 97-122
                    int numberTwo = random.nextInt(122 - 97 + 1) + 97;
                    char numberChar = (char) numberTwo;
                    str.append(numberChar);
                    break;
                }
                case 2:{
                    //产生大写字母 65-90
                    int numberThree = random.nextInt(90 - 65 + 1) + 65;
                    char numberChar = (char) numberThree;
                    str.append(numberChar);
                    break;
                }
                default:{
                    str.append(DEFAULT_NUMBER);
                }
           }

        }
        return str.toString();
    }
}



















