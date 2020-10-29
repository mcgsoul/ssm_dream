package com.feilonkji.www.service.impl;

import com.feilonkji.www.dao.UpvoteMapper;
import com.feilonkji.www.entity.Upvote;
import com.feilonkji.www.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title: UpvoteServiceImpl
 * @Description:
 * @Author zr
 * @Date:2020/9/25 9:54
 * @Version 1.8
 */
@Service
public class UpvoteServiceImpl implements UpvoteService {

    @Autowired
    private UpvoteMapper upvoteMapper;

    @Override
    public Upvote findByUidAndConId(Upvote upvote) {
        return null;
    }

    @Override
    public int add(Upvote upvote) {
        return 0;
    }

    @Override
    public Upvote getByUid(Upvote upvote) {
        return null;
    }

    @Override
    public void update(Upvote upvote) {

    }

    @Override
    public void deleteByContentId(Long cid) {

    }

    @Override
    public Upvote findById(Long id) {
        Upvote up = new Upvote();
        up.setId(id);
        return upvoteMapper.selectOne(up);
    }
}
