package com.feilonkji.www.service;

import com.feilonkji.www.common.PageHelper;
import com.feilonkji.www.entity.Comment;
import com.feilonkji.www.entity.UserContent;

import java.util.List;

/**
 * @title: UserContentService
 * @Description: 用户帖子中间服务接口
 * @Author zr
 * @Date:2020/9/24 21:10
 * @Version 1.8
 */
public interface UserContentService {

    /**
     *
     * Description: 分页查询所有Content
     * @param content 帖子对象
     * @param pageNum 当前页号
     * @param pageSize 当前页数量
     * @return java.util.List<com.feilonkji.www.entity.UserContent>
     * @throws
     * @date 2020/9/24
     */
    List<UserContent> findAll(UserContent content,Integer pageNum,Integer pageSize);
    /**
     *
     * Description: 分页查询所有Content
     * @param content 帖子对象
     * @param comment 评论对象
     * @param pageNum 当前页号
     * @param pageSize 当前页数量
     * @return java.util.List<com.feilonkji.www.entity.UserContent>
     * @throws
     * @date 2020/9/24
     */
    List<UserContent> findAll(UserContent content, Comment comment, Integer pageNum, Integer pageSize);

    /**
     *
     * Description: 分页查询所有Content
     * @param content 帖子对象
     * @param pageNum 当前页号
     * @param pageSize 当前页数量
     * @return java.util.List<com.feilonkji.www.entity.UserContent>
     * @throws
     * @date 2020/9/24
     */
    List<UserContent> findAllByUpvote(UserContent content, Integer pageNum, Integer pageSize);

    /**
     *
     * Description: 添加帖子
     * @param content
     * @return int
     * @throws
     * @date 2020/9/24
     */
    int addContent(UserContent content);

    /**
     *
     * Description: 根据用户id查询帖子集合
     * @param uid
     * @return java.util.List<com.feilonkji.www.entity.UserContent>
     * @throws
     * @date 2020/9/24
     */
    List<UserContent> findByUserId(Long uid);

    /**
     *
     * Description: 查询所有帖子
     * @param
     * @return java.util.List<com.feilonkji.www.entity.UserContent>
     * @throws
     * @date 2020/9/24
     */
    List<UserContent> findAll();

    /**
     *
     * Description: 根据帖子id查找文章
     * @param id
     * @return com.feilonkji.www.entity.UserContent
     * @throws
     * @date 2020/9/24
     */
    UserContent findById(long id);

    /**
     *
     * Description: 根据帖子id更新文章
     * @param content
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void updateById(UserContent content);

    /**
     *
     * Description: 根据用户id查询出帖子分类
     * @param uid
     * @return java.util.List<com.feilonkji.www.entity.UserContent>
     * @throws
     * @date 2020/9/24
     */
    List<UserContent> findCategoryByUid(Long uid);


     /**
      *
      * Description: 根据文章分类查询所有文章
      * @param category 类别
      * @param uid 用户id
      * @param pageNum 当前页号
      * @param pageSize 当前页数量
      * @return com.feilonkji.www.common.PageHelper.Page<com.feilonkji.www.entity.UserContent>
      * @throws
      * @date 2020/9/24
      */
    PageHelper.Page<UserContent> findByCategory(String category, Long uid , Integer pageNum, Integer pageSize);

    /**
     * 根据用户id查询所有私密帖子并分页
     * @param uid 用户id
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UserContent> findPersonal(Long uid ,Integer pageNum, Integer pageSize);

    /**
     *
     * Description: 根据帖子id删除帖子
     * @param cid 帖子id
     * @return void
     * @throws
     * @date 2020/9/24
     */
    void deleteById(Long cid);

    /**
     *
     * Description: 根据发布时间倒排序并分页
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.feilonkji.www.entity.UserContent>
     * @throws
     * @date 2020/9/24
     */
    List<UserContent> findAll(Integer pageNum, Integer pageSize);
}
