package com.feilonkji.www.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @title: Upvote
 * @Description: 帖子点赞类
 * @Author zr
 * @Date:2020/9/24 19:28
 * @Version 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Upvote {

    /**文章点赞表id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**点赞用户id*/
    private Long uId;

    /**帖子id*/
    private Long contentId;

    /**点赞用户ip*/
    private String ip;

    /**点赞*/
    private String upvote;

    /**踩*/
    private String downvote;

    /**点赞时间*/
    private Date upvoteTime;

}