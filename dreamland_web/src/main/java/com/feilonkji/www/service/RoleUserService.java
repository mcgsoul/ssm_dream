package com.feilonkji.www.service;

import com.feilonkji.www.entity.RoleUser;
import com.feilonkji.www.entity.User;

import java.util.List;

/**
 * @title: RoleUserService
 * @Description: 角色用户中间服务接口
 * @Author zr
 * @Date:2020/9/24 21:02
 * @Version 1.8
 */
public interface RoleUserService {

    /**
     *
     * Description: 根据用户查询角色用户集合
     * @param user 用户对象
     * @return java.util.List<com.feilonkji.www.entity.RoleUser>
     * @throws
     * @date 2020/9/24
     */
    List<RoleUser> findByUser(User user);

    /**
     *
     * Description: 添加用户角色中间对象
     * @param roleUser
     * @return int
     * @throws
     * @date 2020/9/24
     */
    int add(RoleUser roleUser);

    /**
     *
     * Description: 根据用户id删除
     * @param uid
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void deleteByUid(Long uid);
}
