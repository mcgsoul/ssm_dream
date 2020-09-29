package com.feilonkji.www.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.ognl.Evaluation;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @title: Role
 * @Description: 角色类
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    /**角色id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**角色名称*/
    private String roleName;

    /**角色值*/
    private String roleValue;

    /**角色可访问URL*/
    private String roleMatcher;

    /**角色是否可用*/
    private String enabled;

    /**备注*/
    private String remark;

}