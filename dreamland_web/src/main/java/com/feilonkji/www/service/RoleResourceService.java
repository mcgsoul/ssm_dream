package com.feilonkji.www.service;

import com.feilonkji.www.entity.RoleResource;

import java.time.format.ResolverStyle;
import java.util.List;

/**
 * @title: RoleResourceService
 * @Description: 角色资源中间服务接口
 * @Author zr
 * @Date:2020/9/24 20:53
 * @Version 1.8
 */
public interface RoleResourceService {

    /**
     *
     * Description: 添加roleResource
     * @param roleResource
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void add(RoleResource roleResource);

    /**
     *
     * Description: 根据id查询RoleResource
     * @param id
     * @return com.feilonkji.www.entity.RoleResource
     * @throws
     * @date 2020/9/24
     */
    RoleResource findById(Long id);

    /**
     *
     * Description: 根据角色id查询角色资源集合
     * @param rid 角色id
     * @return java.util.List<com.feilonkji.www.entity.RoleResource>
     * @throws
     * @date 2020/9/24
     */
    List<RoleResource> findByRoleId(Long rid);

    /**
     *
     * Description: 根据id删除RoleResource
     * @param id
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void deleteById(Long id);
}
