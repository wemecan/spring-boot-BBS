package com.bbs.service.inte;

import com.bbs.pojo.Question;

import java.util.List;

public interface QuestionServiceInte {


    List<Question> getAllQuestion(Integer page,String search);

    /**
     * 添加问题
     * @param question
     * @return
     */
    int addQuestionOrUpdate(Question question);
    /**
     * 根据id获取问题列表
     * @param userId
     * @param page
     * @return
     */
    List<Question> getQuestionById(Integer userId,Integer page,Integer questionId);

    /**
     * 增加阅读量
     * @param id
     * @return
     */
    int incView(Integer id);

    /**
     * 增加评论数
     * @param id
     * @return
     */
    int updateCommentCount(Integer id);

    /**
     * 查询相关问题
     * @param question
     * @return
     */
    List<Question> queryRelatedQuestion(Question question);
}
