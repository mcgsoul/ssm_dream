package com.feilonkji.www.controller;

import com.fasterxml.jackson.databind.util.ObjectIdMap;
import com.feilonkji.www.entity.User;
import com.feilonkji.www.service.UserService;
import com.github.pagehelper.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @title: RegisterController
 * @Description: 注册请求处理
 * @Author zr
 * @Date:2020/9/27 17:11
 * @Version 1.8
 */
@Controller
public class RegisterController {

    private static final Logger LOG = Logger.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    /**
     *
     * Description: 检查电话号码是否可用
     * @param phone 电话号码
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     * @date 2020/9/27
     */
    @RequestMapping(value = "/checkPhone")
    @ResponseBody
    public Map<String,Object> checkPhone(@RequestParam(value = "phone",required = false) String phone){
        LOG.debug("检查要注册的手机号码====>"+phone+"====>是否可用?");
        Map map = new HashMap<String,Object>();
        /**根据电话号码查询用户信息*/
        User user = userService.findByPhone(phone);
        if(user == null){
            //未注册，可用
            map.put("message","success");
        }else {
            //已注册，不可用
            map.put("message","fail");
        }
        LOG.debug("手机号码检查完成，状态===》"+map.get("message"));
        return map;
    }

    @RequestMapping(value = "/checkCode")
    @ResponseBody
    public Map<String,Object> checkCode(HttpServletRequest request, @RequestParam(value = "code",required = false)String code){
        LOG.debug("检查验证码是否正确===>验证码===>"+code);
        Map map = new HashMap<String, Object>();
        //获取生成的验证码数据
        String oldCode = (String) request.getSession().getAttribute(CodeCaptchaController.CODE_SIGN);
        //全部转换成小写对比，不区分大小写
        if(oldCode.toLowerCase().equals(code.toLowerCase())){
            //验证码正确
            map.put("message","success");
        }else {
            //验证码错误
            map.put("message","fail");
        }
        LOG.debug("验证码检查完成===>验证码检查状态===>"+map.get("message"));
        return map;
    }

    @RequestMapping(value = "/doRegister")
    public String register(Model model,User user,@RequestParam(value = "code")String code){
        LOG.debug("注册表单提交===>开始注册===>用户信息===>"+user+"验证码===>"+code);
        if(StringUtils.isEmpty(code)){
            model.addAttribute("error","非法注册，请重新注册！");
            return "../register";
        }
        User newUser = userService.findByEmail(user.getEmail());
        if(user != null){
            model.addAttribute("error","该用户已经被注册！");
            return "../register";
        }else {
            newUser = user;
            //设置初始状态为0 ，0为未激活状态，1为激活状态
            newUser.setState("0");
            //设置初始状态为0 ，0为不可用状态，1为可用状态
            newUser.setEnable("0");
            newUser.setImgUrl("/images/icon_m.jpg");
            //生成邮件激活码

        }
        return "";
    }
}
