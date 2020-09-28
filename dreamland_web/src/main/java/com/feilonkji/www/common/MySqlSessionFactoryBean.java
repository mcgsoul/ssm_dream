package com.feilonkji.www.common;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.IOException;

/**
 * @title: MySqlSessionFactoryBean
 * @Description: 启动死循环打印日志解决工具类
 * @Author zr
 * @Date:2020/9/28 15:27
 * @Version 1.8
 */
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {

    @Override
    protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
        try {
            return super.buildSqlSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
