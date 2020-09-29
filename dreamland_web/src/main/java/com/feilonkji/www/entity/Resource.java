package com.feilonkji.www.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @title: Resource
 * @Description: 资源类
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    /**资源id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**资源名称*/
    private String name;

    /**资源对应url*/
    private String url;

    /**资源是否可用*/
    private String enabled;

    /**资源备注*/
    private String remark;

}