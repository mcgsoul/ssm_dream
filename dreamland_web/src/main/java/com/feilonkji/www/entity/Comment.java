package com.feilonkji.www.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @title: Comment
 * @Description: 评论类
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    /**评论id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**帖子id*/
    private Long conId;

    /**评论者id*/
    private Long comId;

    /**被评论者id*/
    private Long byId;

    /**评论时间*/
    private Date commTime;

    /**子评论ids*/
    private String children;

    /**评论点赞数*/
    private Integer upvote;

    /**评论内容*/
    private String comContent;

    /**评论者*/
    @Transient
    private User user;

    /**被评论者*/
    @Transient
    private User byUser;

    /**子评论集合*/
    @Transient
    private List<Comment> comList;


}