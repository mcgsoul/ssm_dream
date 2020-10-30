package com.feilonkji.www.dao;

import com.feilonkji.www.entity.Comment;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *
 * Description: 评论接口
 * @author 邹荣
 * @date 2020/10/26
 */
public interface CommentMapper extends Mapper<Comment> {

  /**
     *
     * Description: 根据帖子的id查询所有评论
     * @param cid 帖子的id
     * @return java.util.List<com.feilonkji.www.entity.Comment>
     * @throws
     * @date 2020/10/29
     */
    List<Comment> selectAllComment(@Param("cid") long cid);

    /**
     *
     * Description: 根据帖子id查询所有一级评论
     * @param cid 帖子id
     * @return java.util.List<com.feilonkji.www.entity.Comment>
     * @throws
     * @date 2020/10/29
     */
    List<Comment> findAllFirstComment(@Param("cid") long cid);

    /**
     *
     * Description: 根据帖子id和二级评论ids查询出所有二级评论
     * @param cid
     * @return java.util.List<com.feilonkji.www.entity.Comment>
     * @throws
     * @date 2020/10/29
     */
    List<Comment> findAllChildrenComment(@Param("cid") long cid,@Param("children") String children);

    /**
     *s
     * Description: 插入评论并返回主键id，返回值为影响的行数 ，返回的主键id再Comment对象中
     * @param comment 返回后包含主键id的对象
     * @return int 影响的行数
     * @throws
     * @date 2020/10/29
     */
    int insertComment(Comment comment);


}











