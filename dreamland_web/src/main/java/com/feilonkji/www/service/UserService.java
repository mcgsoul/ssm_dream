package com.feilonkji.www.service;

import com.feilonkji.www.entity.User;

/**
 * @title: UserService
 * @Description: 用户服务接口
 * @Author zr
 * @Date:2020/9/24 19:15
 * @Version 1.8
 */
public interface UserService {

    /**
     *
     * Description: 用户注册
     * @param user 用户对象
     * @return int
     * @throws
     * @date 2020/9/24
     */
    int regist(User user);
    
    /**
     *
     * Description: 用户登陆
     * @param email 邮箱
     * @param password 密码
     * @return com.feilonkji.www.entity.User
     * @throws
     * @date 2020/9/24
     */
    User login(String email,String password);

    /**
     *
     * Description: 根据用户邮箱查询用户
     * @param email 用户邮箱
     * @return com.feilonkji.www.entity.User
     * @throws
     * @date 2020/9/24
     */
    User findByEmail(String email);

    /**
     *
     * Description: 根据用户手机号查询用户
     * @param phone 用户手机号
     * @return com.feilonkji.www.entity.User
     * @throws
     * @date 2020/9/25
     */
    User findByPhone(String phone);

    /**
     *
     * Description: 根据用户id查询用户
     * @param id
     * @return com.feilonkji.www.entity.User
     * @throws
     * @date 2020/9/25
     */
    User findById(Long id);

    /**
     *
     * Description: 根据邮箱账号删除用户
     * @param email 用户邮箱
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void deleteByEmail(String email);

    /**
     *
     * Description: 更新用户信息
     * @param user 用户对象
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void update(User user);
    
}
