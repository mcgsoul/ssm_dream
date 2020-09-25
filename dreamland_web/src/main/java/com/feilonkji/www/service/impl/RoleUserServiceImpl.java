package com.feilonkji.www.service.impl;

import com.feilonkji.www.entity.RoleUser;
import com.feilonkji.www.entity.User;
import com.feilonkji.www.service.RoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: RoleUserServiceImpl
 * @Description:
 * @Author zr
 * @Date:2020/9/25 9:53
 * @Version 1.8
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {
    @Override
    public List<RoleUser> findByUser(User user) {
        return null;
    }

    @Override
    public int add(RoleUser roleUser) {
        return 0;
    }

    @Override
    public void deleteByUid(Long uid) {

    }
}
