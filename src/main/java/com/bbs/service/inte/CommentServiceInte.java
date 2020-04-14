package com.bbs.service.inte;

import com.bbs.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentServiceInte {
    /**
     * 添加评论
     * @param comment
     * @return
     */
    int createComment(Comment comment,Integer questionId);
    /**
     * 根据问题 id获取评论
     * @param questionId
     * @return
     */
    List<Comment> queryCommentByQuestionId(Integer questionId,Integer page,Integer type);
    /**
     * 获取评论的回复数
     * @param questionId
     * @return
     */
    Integer queryReplyCountById(Integer commentId,Integer questionId,Integer type);
    /**
     * 点赞评论
     * @param commentId
     * @return
     */
    Integer like(Integer commentId,Integer likeOrOff,Integer likeCount);
}
