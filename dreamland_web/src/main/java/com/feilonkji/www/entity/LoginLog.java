package com.feilonkji.www.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @title: LoginLog
 * @Description: 登陆日志类
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginLog {

    /**登陆日志id*/
    private Long id;

    /**用户id*/
    private Long uId;

    /**登陆ip*/
    private String ip;

    /**登陆时间*/
    private Date createTime;

}