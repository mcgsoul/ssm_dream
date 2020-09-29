package com.feilonkji.www.mail;

import org.apache.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * @title: SendEmailUtil
 * @Description: 邮件发送工具类
 * @Author zr
 * @Date:2020/9/28 10:11
 * @Version 1.8
 */
public class SendEmailUtil {

    private final static Logger LOG = Logger.getLogger(SendEmailUtil.class);

    /**
     *
     * Description: 邮件发送方法
     * @param email 收件人信箱
     * @param validateCode 激活码
     * @return void
     * @throws MessagingException
     * @date 2020/9/28
     */
    public static void sendEmailMessage(String name,String email,String validateCode) throws MessagingException {
        //发件人信箱服务地址
        String host = "smtp.qq.com";
        String from = "2409046585@qq.com";
        //收件人信箱
        String to = email;
        //获取系统配置
        Properties properties = System.getProperties();
        //设置邮件服务器
        properties.put("mail.smtp.host",host);
        //设置验证
        properties.put("mail.smtp.auth","true");
        MyAuthenticator myAuthenticator = new MyAuthenticator(from,"***");
        Session session = Session.getDefaultInstance(properties,myAuthenticator);
        //设置邮件信息主体
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("梦幻家园网激活邮件通知");
            message.setContent("亲爱的【"+name+"】，您好" +"<br/>"+
                    "欢迎您注册梦幻家园网，<a href=\"http://localhost:8080/activeCode?email="+email+
                    "&validateCode="+validateCode+"\" target=\"_blank\">请于24小时内点击激活</a>账户，方可正常使用。24小时后将自动失效。" +"<br/>"+
                    "                                          梦幻家园开发组---小梦","text/html;charset=gb2312");

            message.saveChanges();
            Transport.send(message);
            LOG.info("激活码===>"+validateCode+"发送到邮箱===>"+email+"===>成功");
        } catch (MessagingException e) {
            LOG.error("发送邮件出现异常===>"+e.getMessage());
            throw e;
        }

    }

}














