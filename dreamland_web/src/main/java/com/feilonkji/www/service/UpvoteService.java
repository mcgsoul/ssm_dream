package com.feilonkji.www.service;

import com.feilonkji.www.entity.Upvote;

/**
 * @title: UpvoteService
 * @Description: 点赞服务接口
 * @Author zr
 * @Date:2020/9/24 21:05
 * @Version 1.8
 */
public interface UpvoteService {

    /**
     *
     * Description: 根据用户id和文章id查询
     * @param upvote 点赞对象
     * @return com.feilonkji.www.entity.Upvote
     * @throws
     * @date 2020/9/24
     */
    Upvote findByUidAndConId(Upvote upvote);

    /**
     *
     * Description: 添加点赞
     * @param upvote
     * @return int
     * @throws
     * @date 2020/9/24
     */
    int add(Upvote upvote);

    /**
     *
     * Description: 根据用户id查询最后一次登陆的Upvote
     * @param upvote
     * @return com.feilonkji.www.entity.Upvote
     * @throws
     * @date 2020/9/24
     */
    Upvote getByUid(Upvote upvote);

    /**
     *
     * Description: 更新Upvote
     * @param upvote
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void update(Upvote upvote);

    /**
     *
     * Description: 根据文章id删除Upvote
     * @param cid 文章id
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void deleteByContentId(Long cid);

    /**
     *
     * Description: 根据id查询
     * @param id
     * @return Upvote
     * @throws
     * @date 2020/10/29
     */
    Upvote findById(Long id);

}
