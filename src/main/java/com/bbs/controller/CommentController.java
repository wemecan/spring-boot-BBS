package com.bbs.controller;

import com.bbs.pojo.Comment;
import com.bbs.pojo.User;
import com.bbs.service.inte.CommentServiceInte;
import com.bbs.service.inte.QuestionServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentServiceInte commentServiceInte;

    //问题业务逻辑层接口
    @Autowired
    private QuestionServiceInte questionServiceInte;
    /**
     * 创建评论
     * @param comment
     * @return
     */
    @RequestMapping("createComment")
    @ResponseBody
    public String createComment(Integer questionId,Comment comment, HttpSession session){
        User user = (User)session.getAttribute("USER");
        comment.setUser(user);
        int count = commentServiceInte.createComment(comment,questionId);

        return count+"";
    }

    /**
     * 获取二级评论
     * @return
     */
    @PostMapping("getSecondComment")
    @ResponseBody
    public List<Comment> querySecondComment(Integer parentId){
        //获取二级评论  type = 1 代表二级
        List<Comment> comments = commentServiceInte.queryCommentByQuestionId(parentId,0,1);

        return comments;
    }

    /**
     * 点赞评论
     * @param commentId
     * @return
     */
    @RequestMapping(value = "likeComm",method = RequestMethod.POST)
    @ResponseBody
    public String likeComment(Integer commentId,Integer likeOrOff,Integer likeCount,HttpSession session){

        User user = (User)session.getAttribute("USER");
        int count = 0;
        if (user != null){
            count = commentServiceInte.like(commentId,likeOrOff,likeCount);
        }

        return count+"";
    }

    /**
     * 判断session中的用户是否存在
     * @return
     */
    @RequestMapping(value = "getSessionUser",method = RequestMethod.POST)
    @ResponseBody
    public String getSessionUser(HttpSession session){
        User user = (User)session.getAttribute("USER");

        if (user != null){

            return ""+1;
        }else{
            return ""+0;
        }


    }

}
