package com.feilonkji.www.service;

import com.feilonkji.www.entity.Comment;

import java.util.List;

/**
 * @title: CommentService
 * @Description: 评论服务接口
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */
public interface CommentService {

    /**
     *
     * Description: 添加评论
     * @param comment 评论对象
     * @return int
     * @throws
     * @date 2020/9/24
     */
    int add(Comment comment);
    
    /**
     *
     * Description: 更新评论
     * @param comment
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void update(Comment comment);
    
    /**
     *
     * Description: 根据帖子id查询所有评论
     * @param content_id 帖子id
     * @return java.util.List<com.feilonkji.www.entity.Comment>
     * @throws
     * @date 2020/9/24
     */
    List<Comment> findAll(Long content_id);
    
    /**
     *
     * Description: 根据id查评论
     * @param id 评论id
     * @return com.feilonkji.www.entity.Comment
     * @throws
     * @date 2020/9/24
     */
    Comment findById(Long id);

    /**
     *
     * Description: 根据帖子id查所有父级评论
     * @param content_id
     * @return java.util.List<com.feilonkji.www.entity.Comment>
     * @throws
     * @date 2020/9/24
     */
    List<Comment> findAllFirstComment(Long content_id);

    /**
     *
     * Description: 根据帖子id和评论ids查询所有子评论
     * @param content_id 帖子id
     * @param children 子评论id
     * @return java.util.List<com.feilonkji.www.entity.Comment>
     * @throws
     * @date 2020/9/24
     */
    List<Comment> findAllChildComment(Long content_id,String children);

    /**
     *
     * Description: 根据id删除评论
     * @param id 评论id
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void deleteById(Long id);

    /**
     *
     * Description: 根据子评论id，批量删除子评论
     * @param children 子评论ids
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void deleteChildrenComment(String children);

    /**
     *
     * Description: 根据帖子id删除评论
     * @param cid 帖子id
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void deleteByContentId(Long cid);



}
