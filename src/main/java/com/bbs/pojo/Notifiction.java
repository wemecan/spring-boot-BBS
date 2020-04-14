package com.bbs.pojo;

import lombok.Data;

/**
 * 通知实体类
 */
@Data
public class Notifiction {

    private int id;
    private User notifier; //通知人
    private User receiver;  //接收人
    private Object outer;   //回复或者评论 对象
    private int type;  //判断回复 评论  点赞
    private String createTime;  //创建时间
    private int status; //状态   0 - 未读   1- 已读
    private int outerId;  //评论或者 问题的id
    private Comment comment;  //评论
    private Question question;  //问题

}
