package com.feilonkji.www.dao;

import com.feilonkji.www.entity.Upvote;

public interface UpvoteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Upvote record);

    int insertSelective(Upvote record);

    Upvote selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Upvote record);

    int updateByPrimaryKey(Upvote record);
}