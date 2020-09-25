package com.feilonkji.www.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: RoleUser
 * @Description: 角色用户中间类
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUser {

    /**角色用户中间表id*/
    private Long id;

    /**用户id*/
    private Long uId;

    /**角色id*/
    private Long rId;

}