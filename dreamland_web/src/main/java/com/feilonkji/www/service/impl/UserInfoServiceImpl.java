package com.feilonkji.www.service.impl;

import com.feilonkji.www.entity.UserInfo;
import com.feilonkji.www.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @title: UserInfoServiceImpl
 * @Description:
 * @Author zr
 * @Date:2020/9/25 9:57
 * @Version 1.8
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public UserInfo findByUid(Long id) {
        return null;
    }

    @Override
    public void update(UserInfo userInfo) {

    }

    @Override
    public void add(UserInfo userInfo) {

    }
}
