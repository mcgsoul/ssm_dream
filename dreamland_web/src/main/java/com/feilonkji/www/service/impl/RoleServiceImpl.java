package com.feilonkji.www.service.impl;

import com.feilonkji.www.entity.Role;
import com.feilonkji.www.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: RoleServiceImpl
 * @Description:
 * @Author zr
 * @Date:2020/9/25 9:52
 * @Version 1.8
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Role findById(Long id) {
        return null;
    }

    @Override
    public int add(Role role) {
        return 0;
    }

    @Override
    public List<Role> findByUid(Long uid) {
        return null;
    }
}
