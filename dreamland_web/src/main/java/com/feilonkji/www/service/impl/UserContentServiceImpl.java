package com.feilonkji.www.service.impl;

import com.feilonkji.www.common.PageHelper;
import com.feilonkji.www.entity.Comment;
import com.feilonkji.www.entity.UserContent;
import com.feilonkji.www.service.UserContentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: UserContentServiceImpl
 * @Description:
 * @Author zr
 * @Date:2020/9/25 9:55
 * @Version 1.8
 */
@Service
public class UserContentServiceImpl implements UserContentService {
    @Override
    public List<UserContent> findAll(UserContent content, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<UserContent> findAll(UserContent content, Comment comment, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<UserContent> findAllByUpvote(UserContent content, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public int addContent(UserContent content) {
        return 0;
    }

    @Override
    public List<UserContent> findByUserId(Long uid) {
        return null;
    }

    @Override
    public List<UserContent> findAll() {
        return null;
    }

    @Override
    public UserContent findById(long id) {
        return null;
    }

    @Override
    public void updateById(UserContent content) {

    }

    @Override
    public List<UserContent> findCategoryByUid(Long uid) {
        return null;
    }

    @Override
    public PageHelper.Page<UserContent> findByCategory(String category, Long uid, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<UserContent> findPersonal(Long uid, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public void deleteById(Long cid) {

    }

    @Override
    public List<UserContent> findAll(Integer pageNum, Integer pageSize) {
        return null;
    }
}
