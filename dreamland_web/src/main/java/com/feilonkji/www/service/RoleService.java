package com.feilonkji.www.service;

import com.feilonkji.www.entity.Role;

import java.util.List;

/**
 * @title: RoleService
 * @Description: 角色服务接口
 * @Author zr
 * @Date:2020/9/24 20:57
 * @Version 1.8
 */
public interface RoleService {
    /**
     *
     * Description: 根据id查询角色
     * @param id
     * @return com.feilonkji.www.entity.Role
     * @throws
     * @date 2020/9/24
     */
    Role findById(Long id);

    /**
     *
     * Description: 添加角色
     * @param role 角色对象
     * @return int
     * @throws
     * @date 2020/9/24
     */
    int add(Role role);

    /**
     *
     * Description: 根据用户id查询所有的角色
     * @param uid
     * @return java.util.List<com.feilonkji.www.entity.Role>
     * @throws
     * @date 2020/9/24
     */
    List<Role> findByUid(Long uid);
}
