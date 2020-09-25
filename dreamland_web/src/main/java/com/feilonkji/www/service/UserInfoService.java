package com.feilonkji.www.service;


import com.feilonkji.www.entity.UserInfo;

/**
 * @title: UserInfoService
 * @Description: 用户详细信息类服务接口
 * @Author zr
 * @Date:2020/9/24 21:10
 * @Version 1.8
 */
public interface UserInfoService {

    /**
     *
     * Description: 根据用户id查找用户详细信息
     * @param id
     * @return com.feilonkji.www.entity.UserInfo
     * @throws
     * @date 2020/9/24
     */
    UserInfo findByUid(Long id);

    /**
     *
     * Description: 更新用户详细信息
     * @param userInfo
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void update(UserInfo userInfo);

    /**
     *
     * Description: 添加用户详细新
     * @param userInfo
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void add(UserInfo userInfo);

}
