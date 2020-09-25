package com.feilonkji.www.dao;

import com.feilonkji.www.entity.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @title: UserMapper
 * @Description: 用户持久层接口
 * @Author zr
 * @Date:2020/9/25 10:04
 * @Version 1.8
 */
public interface UserMapper extends Mapper<User> {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}