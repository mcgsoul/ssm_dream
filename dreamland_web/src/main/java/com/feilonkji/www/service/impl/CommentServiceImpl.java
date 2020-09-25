package com.feilonkji.www.service.impl;

import com.feilonkji.www.entity.Comment;
import com.feilonkji.www.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: CommentServiceImpl
 * @Description: 评论服务接口实现类
 * @Author zr
 * @Date:2020/9/25 9:32
 * @Version 1.8
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public int add(Comment comment) {
        return 0;
    }

    @Override
    public void update(Comment comment) {

    }

    @Override
    public List<Comment> findAll(Long content_id) {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }

    @Override
    public List<Comment> findAllFirstComment(Long content_id) {
        return null;
    }

    @Override
    public List<Comment> findAllChildComment(Long content_id, String children) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteChildrenComment(String children) {

    }

    @Override
    public void deleteByContentId(Long cid) {

    }
}
