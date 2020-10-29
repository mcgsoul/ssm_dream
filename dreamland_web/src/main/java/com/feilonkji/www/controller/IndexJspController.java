package com.feilonkji.www.controller;

import com.fasterxml.jackson.databind.util.ObjectIdMap;
import com.feilonkji.www.common.Constant;
import com.feilonkji.www.common.RandStringUtils;
import com.feilonkji.www.entity.Upvote;
import com.feilonkji.www.entity.User;
import com.feilonkji.www.entity.UserContent;
import com.feilonkji.www.service.UpvoteService;
import com.feilonkji.www.service.UserContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: IndexJspController
 * @Description: 首页帖子数据请求处理
 * @Author zr
 * @Date:2020/10/29 15:07
 * @Version 1.8
 */
@Controller
public class IndexJspController {

    private final static Logger LOG = Logger.getLogger(IndexJspController.class);

    @Autowired
    private UserContentService userContentService;

    @Autowired
    private UpvoteService upvoteService;

    @RequestMapping(value = "/index_list")
    public String findAllList(HttpServletRequest request, Model model, @RequestParam(value = "id",required = false) String id,
                              @RequestParam(value = "pageNum",required = false) Integer pageNum,
                              @RequestParam(value = "pageSize",required = false) Integer pageSize){
        LOG.debug("============进入首页==========");
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            model.addAttribute("user",user);
        }
        if(pageSize == null){
            pageSize = Constant.INDEX_PAGESIZE;
        }
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<UserContent> all = userContentService.findAll();
        //分装分页数据到对象
        PageInfo<UserContent> pageInfo = new PageInfo<UserContent>(all);
        model.addAttribute("page",pageInfo);
        return "../index";
    }

    /**
     *
     * Description: 帖子点赞和踩请求的处理方法
     * @param model 内置模型对象
     * @param id 帖子id
     * @param upvote 赞或者踩的标志，1为赞，-1为踩
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     * @date 2020/10/29
     */
    @RequestMapping(value = "/upvote")
    @ResponseBody
    public Map<String,Object> upvote(HttpServletRequest request,Long id,Integer upvote){
        LOG.debug("开始赞或者踩===>"+"帖子id===>"+id+"upvote状态===>"+upvote);
        Map map = new HashMap<String, Object>();
        //检查是否登陆
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            map.put("data","fail");
            return map;
        }
        Upvote up = new Upvote();
        up.setContentId(id);
        up.setUId(user.getId());
        //从点赞表中查询当天当前用户是否已经点赞或踩过这篇帖子
        Upvote upv = upvoteService.findByUidAndConId(up);
        //根据帖子id获取帖子的详细信息
        UserContent userContent = userContentService.findById(id);
        //upvote为-1代表踩
        if(upvote == -1){
            if(upv != null){
                //代表已经踩过
                if(Constant.STATE_MINUS_ONE.equals(upv.getDownvote())){
                    map.put("data","down");
                    return map;
                }else {
                    upv.setDownvote(Constant.STATE_ONE);
                    upv.setUpvoteTime(new Date());
                    upv.setIp(RandStringUtils.getClientIpAddress());
                    upvoteService.update(upv);
                }
            }else {
                //未踩过,新增踩记录，防止重复踩
                up.setDownvote(Constant.STATE_ONE);
                up.setUpvoteTime(new Date());
                up.setIp(RandStringUtils.getClientIpAddress());
                upvoteService.add(up);
            }
            LOG.debug("点赞或踩结束===本次为踩，状态码===>"+upvote);
            userContent.setDownvote(userContent.getDownvote() + upvote);
        }else {
            //表示赞
            if(upv != null){
                if(Constant.STATE_ONE.equals(upv.getUpvote())){
                    map.put("data","done");
                    return map;
                }else {
                    upv.setUpvote(Constant.STATE_ONE);
                    upv.setUpvoteTime(new Date());
                    upv.setIp(RandStringUtils.getClientIpAddress());
                    upvoteService.update(upv);
                }
            }else {
                //没有点赞
                up.setUpvote(Constant.STATE_ONE);
                up.setUpvoteTime(new Date());
                up.setIp(RandStringUtils.getClientIpAddress());
                upvoteService.add(up);
            }
            userContent.setUpvote(userContent.getUpvote() + upvote);
            LOG.debug("点赞或踩结束===本次为赞，状态码===>"+upvote);
        }
        userContentService.updateById(userContent);
        map.put("data","success");
        LOG.debug("赞或踩===>结束");
        return map;
    }

}















