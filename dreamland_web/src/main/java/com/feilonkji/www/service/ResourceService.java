package com.feilonkji.www.service;

import com.feilonkji.www.entity.Resource;

import java.util.List;

/**
 * @title: ResourceService
 * @Description: 资源服务接口
 * @Author zr
 * @Date:2020/9/24 19:56
 * @Version 1.8
 */
public interface ResourceService {

    /**
     *
     * Description: 添加资源
     * @param resource 资源对象
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void add(Resource resource);

    /**
     *
     * Description: 根据资源id查询资源
     * @param id 资源id
     * @return com.feilonkji.www.entity.Resource
     * @throws
     * @date 2020/9/24
     */
    Resource findById(Long id);

    /**
     *
     * Description: 查询所有资源
     * @param
     * @return java.util.List<com.feilonkji.www.entity.Resource>
     * @throws
     * @date 2020/9/24
     */
    List<Resource> findAll();

    /**
     *
     * Description: 根据资源id删除资源
     * @param id
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void deleteById(Long id);

    /**
     *
     * Description: 更新资源
     * @param resource 资源对象
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void update(Resource resource);
}
