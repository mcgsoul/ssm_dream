package com.feilonkji.www.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @title: UserInfo
 * @Description: 用户详细信息表
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    /**用户详细信息表id*/
    private Long id;

    /**用户id*/
    private Long uId;

    /**用户姓名*/
    private String name;

    /**用户性别*/
    private String sex;

    /**用户生日*/
    private Date birthday;

    /**用户爱好*/
    private String hobby;

    /**用户地址*/
    private String address;

}