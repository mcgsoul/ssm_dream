package com.feilonkji.www.service.impl;

import com.feilonkji.www.entity.LoginLog;
import com.feilonkji.www.service.LoginLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: LoginLogServiceImpl
 * @Description: 登陆日志服务接口实现
 * @Author zr
 * @Date:2020/9/25 9:45
 * @Version 1.8
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Override
    public int add(LoginLog loginLog) {
        return 0;
    }

    @Override
    public List<LoginLog> findAll() {
        return null;
    }

    @Override
    public List<LoginLog> findByUid(Long uid) {
        return null;
    }
}
