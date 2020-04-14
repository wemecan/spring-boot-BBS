package com.bbs.service.impl;

import com.bbs.mapper.CommentMapper;
import com.bbs.mapper.NotifictionMapper;
import com.bbs.mapper.QuestionMapper;
import com.bbs.pojo.Comment;
import com.bbs.pojo.Notifiction;
import com.bbs.pojo.Question;
import com.bbs.service.inte.NotifictionServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通知业务逻辑层实体类
 */
@Service
public class NotifictionServiceImpl implements NotifictionServiceInte {

    @Autowired
    private NotifictionMapper notifictionMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private CommentMapper commentMapper;
    /**
     * 根据用户 查询通知
     * @param userId
     * @return
     */
    @Override
    public List<Notifiction> queryNotifiction(Integer userId) {
        List<Notifiction> notifictions = notifictionMapper.queryNotifiction(userId);
        //循环查询通知的是评论还是通知
        for (Notifiction notifiction:notifictions
             ) {


            if (notifiction.getType() == 0){

                List<Question> questions = questionMapper.getQuestionById(0,0,notifiction.getOuterId());

                notifiction.setQuestion(questions.get(0));


            }else if(notifiction.getType() == 1){
                //查询是哪条评论
                Comment comment = commentMapper.queryReplyByCommentId(notifiction.getOuterId());
                notifiction.setComment(comment);
            }

        }

        return notifictions;
    }

    /**
     * 把通知改为已读
     * @param notifictionId
     * @return
     */
    public Integer readNotifiction(Integer notifictionId) {

        return notifictionMapper.readNotifiction(notifictionId);
    }

    @Override
    public Integer getUnreadNotifier(Integer userId) {
        return notifictionMapper.getUnreadNotifier(userId);
    }
}
