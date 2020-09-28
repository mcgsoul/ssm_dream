package com.feilonkji.www.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @title: MyAuthenticator
 * @Description: 发件人身份验证类
 * @Author zr
 * @Date:2020/9/28 10:21
 * @Version 1.8
 */
public class MyAuthenticator extends Authenticator {
    private String strUser;
    private String strPwd;
    public MyAuthenticator(String user,String password){
        this.strUser = user;
        this.strPwd = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(strUser,strPwd);
    }
}
