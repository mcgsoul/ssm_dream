package com.feilonkji.www.service.impl;

import com.feilonkji.www.entity.RoleResource;
import com.feilonkji.www.service.RoleResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: RoleResourceServiceImpl
 * @Description: 角色资源中间服务接口实现类
 * @Author zr
 * @Date:2020/9/25 9:48
 * @Version 1.8
 */
@Service
public class RoleResourceServiceImpl implements RoleResourceService {
    @Override
    public void add(RoleResource roleResource) {

    }

    @Override
    public RoleResource findById(Long id) {
        return null;
    }

    @Override
    public List<RoleResource> findByRoleId(Long rid) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
