package com.feilonkji.www.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @title: UserContent
 * @Description: 帖子类
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContent {

    /**帖子id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**用户id*/
    private Long userId;

    /**帖子标题*/
    private String title;

    /**帖子分类*/
    private String category;

    /**是否私有*/
    private String personal;

    /**上传时间*/
    private Date rptTime;

    /**用户头像rul*/
    private String imgUrl;

    /**用户昵称*/
    private String nickName;

    /**点赞*/
    private Integer upvote;

    /**踩*/
    private Integer downvote;

    /**评论数*/
    private Integer commentNum;

    /**帖子内容*/
    private String content;

}