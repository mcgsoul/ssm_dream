package com.feilonkji.www.dao;

import com.feilonkji.www.entity.RoleUser;

public interface RoleUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);

    RoleUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
}