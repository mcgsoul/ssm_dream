package com.feilonkji.www.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: RoleResource
 * @Description: 角色资源类
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResource {

    /**角色资源中间表id*/
    private Long id;

    /**角色id*/
    private Long rId;

    /**资源id*/
    private Long resId;

}