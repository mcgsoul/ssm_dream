package com.feilonkji.www.interceptor;

import com.feilonkji.www.dao.UserContentMapper;
import com.feilonkji.www.entity.UserContent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogRecord;

/**
 * @title: IndexJspFilter
 * @Description: 首页自定义过滤器
 * @Author zr
 * @Date:2020/10/26 19:02
 * @Version 1.8
 */
public class IndexJspFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(IndexJspFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.debug("首页自定义过滤器启动····");
        ServletContext servletContext = servletRequest.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserContentMapper userContentMapper = ctx.getBean(UserContentMapper.class);
        //开始分页，第一页，每页10条
        PageHelper.startPage(1,7);
        List<UserContent> userContentList = userContentMapper.select(null);
        PageInfo<UserContent> pageInfo = new PageInfo<UserContent>(userContentList);
        servletRequest.setAttribute("page",pageInfo);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
