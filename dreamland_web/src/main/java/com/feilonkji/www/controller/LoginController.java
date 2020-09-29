package com.feilonkji.www.controller;

import com.feilonkji.www.common.Constant;
import com.feilonkji.www.common.MD5Util;
import com.feilonkji.www.entity.User;
import com.feilonkji.www.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.jws.WebParam;
import javax.mail.Session;
import javax.servlet.http.HttpSession;

/**
 * @title: LoginController
 * @Description: 登陆请求处理
 * @Author zr
 * @Date:2020/9/29 14:59
 * @Version 1.8
 */
@Controller
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    /**
     *
     * Description: 用户登陆请求处理
     * @param model 界面模型
     * @param user 用户对象
     * @param code 验证码
     * @param phoneCode 手机验证码
     * @return java.lang.String
     * @throws
     * @date 2020/9/29
     */
     @RequestMapping(value = "/doLogin")
     public String doLogin(Model model,User user,@RequestParam(value = "code",required = false) String code,
                           @RequestParam(value = "phoneCode",required = false) String phoneCode){

         LOG.debug("用户登陆===>user信息===>"+user+"验证码===>"+code+"手机验证码===>"+phoneCode);
         //判断验证码是否为空
         if(StringUtils.isEmpty(code)){
             model.addAttribute("error","fail");
             return "../login";
         }
         //检查匹配验证码
         HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
         Object attribute = session.getAttribute(CodeCaptchaController.CODE_SIGN);
         if(attribute == null){
             model.addAttribute("error","fail");
             return "../login";
         }else if(!code.equalsIgnoreCase(attribute.toString())){
             model.addAttribute("error","fail");
             return "../login";
         }
         //以账号作为盐，加密密码
         String salt = user.getEmail();
         String password = MD5Util.encodeToHex(salt + user.getPassword());
         user.setPassword(password);
         User loginUser = userService.login(user.getEmail(), user.getPassword());
         if(loginUser != null){
             if(Constant.STATE_ZERO.equals(loginUser.getState())){
                 //判断账户未激活
                 model.addAttribute("email",user.getEmail());
                 model.addAttribute("error","active");
                 return "../login";
             }
             LOG.info("==============用户登陆成功==================");
             model.addAttribute("user",loginUser);
             session.setAttribute("user",user);
             return "/personal/personal";
         }else {
             //登陆失败
             LOG.info("=============用户登陆失败===============");
             model.addAttribute("email",user.getEmail());
             model.addAttribute("error","fail");
             return "../login";
         }

     }

     /**
      *
      * Description: 相当于过滤器，对用户可以保留15分钟的免登录
      * @param model
      * @return java.lang.String
      * @throws
      * @date 2020/9/29
      */
     @RequestMapping(value = "/login")
     public String login(){
         HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
         User user = (User) session.getAttribute("user");
         if(user != null){
             return "/personal/personal";
         }
         return "../login";
     }


}














