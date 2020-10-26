package com.feilonkji.www.controller;

import com.fasterxml.jackson.databind.util.ObjectIdMap;
import com.feilonkji.www.common.Constant;
import com.feilonkji.www.common.MD5Util;
import com.feilonkji.www.common.RandStringUtils;
import com.feilonkji.www.entity.User;
import com.feilonkji.www.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**ActiveMQ消息模板*/
    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

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
         HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
         //判断是否是手机登录
         if(!StringUtils.isEmpty(user.getPhone())){
             //是手机登录,从redis中拿到手机短信验证码
             String phoneCodeRedis = redisTemplate.opsForValue().get(user.getPhone());
             if(!StringUtils.isEmpty(phoneCode) && phoneCode.equals(phoneCodeRedis)){
                //手机验证码正确
                 User byPhone = userService.findByPhone(user.getPhone());
                 session.setAttribute("user",user);
                 model.addAttribute("user",user);
                 LOG.info("手机登陆成功");
                 return "/personal/personal";
             }else{
                 //手机验证码错误或者过期
                 LOG.info("手机登陆失败"+"验证码===>"+phoneCode);
                 model.addAttribute("error","phone_fail");
                 return "../login";
             }
         }
         //判断验证码是否为空
         if(StringUtils.isEmpty(code)){
             model.addAttribute("error","fail");
             return "../login";
         }
         //检查匹配验证码
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

     @RequestMapping(value = "/sendSms")
     @ResponseBody
    public Map<String,Object> sendMessage(Model model,final String telephone){
         Map map = new HashMap<String, Object>();
         try{
             //获取验证码
             final String code = RandStringUtils.getCode(6);
             //将验证码存入redis并设置过期时间位60秒
             redisTemplate.opsForValue().set(telephone,code,60, TimeUnit.SECONDS);
             LOG.debug("短信验证码为===>"+code);
             //发送消息到ActiveMQ
             jmsTemplate.send("login_msg", new MessageCreator() {
                 @Override
                 public Message createMessage(Session session) throws JMSException {
                     MapMessage mapMessage = session.createMapMessage();
                     mapMessage.setString("telephone",telephone);
                     mapMessage.setString("code",code);
                     return mapMessage;
                 }
             });
         }catch (Exception e){
             map.put("msg",false);
         }
         map.put("msg",true);
         return map;
     }


}














