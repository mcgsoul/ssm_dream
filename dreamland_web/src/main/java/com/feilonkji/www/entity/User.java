package com.feilonkji.www.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @title: User
 * @Description: 用户类
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**用户id*/
    private Long id;

    /**用户邮箱*/
    private String email;

    /**用户密码*/
    private String password;

    /**用户电话*/
    private String phone;

    /**用户昵称*/
    private String nickName;

    /**用户激活状态，设置初始状态为0 ，0为未激活状态，1为激活状态*/
    private String state;

    /**用户头像*/
    private String imgUrl;

    /**用户是否可用，设置初始状态为0 ，0为不可用状态，1为可用状态*/
    private String enable;


}