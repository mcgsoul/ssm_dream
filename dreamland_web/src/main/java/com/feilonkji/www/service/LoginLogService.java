package com.feilonkji.www.service;

import com.feilonkji.www.entity.LoginLog;

import java.util.List;

/**
 * @title: LoginLogService
 * @Description: 登陆日志服务接口
 * @Author zr
 * @Date:2020/9/24 19:51
 * @Version 1.8
 */
public interface LoginLogService {

    /**
     *
     * Description: 添加登陆日志
     * @param loginLog
     * @return int
     * @throws
     * @date 2020/9/24
     */
    int add(LoginLog loginLog);

    /**
     *
     * Description: 查询所有日志
     * @param
     * @return java.util.List<com.feilonkji.www.entity.LoginLog>
     * @throws
     * @date 2020/9/24
     */
    List<LoginLog> findAll();

    /**
     *
     * Description: 根据用户id查询日志
     * @param uid 用户id
     * @return java.util.List<com.feilonkji.www.entity.LoginLog>
     * @throws
     * @date 2020/9/24
     */
    List<LoginLog> findByUid(Long uid);

}
