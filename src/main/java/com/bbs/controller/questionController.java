package com.bbs.controller;

import com.bbs.pojo.Comment;
import com.bbs.pojo.Question;
import com.bbs.service.inte.CommentServiceInte;
import com.bbs.service.inte.QuestionServiceInte;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 问题 文章控制器
 */
@Controller
public class questionController {
    //问题文章业务逻辑层接口
    @Autowired
    QuestionServiceInte questionServiceInte;
    //评论业务逻辑层接口
    @Autowired
    private CommentServiceInte commentServiceInte;

    /**
     * 跳转至问题详情页面
     * @return
     */
    @RequestMapping("question")
    public String doQuestion(){

        return "redirect:/question/1";
    }

    /**
     * 获取问题详情 以及获取评论
     * @param id
     * @return
     */
    @RequestMapping("question/{id}")
    public String getQuestion(@PathVariable("id")Integer id, Model model){
        //增加阅读量
        questionServiceInte.incView(id);
        //获取文章详情
        List<Question> questions = questionServiceInte.getQuestionById(0,0,id);

        //获取评论
        List<Comment> comments = commentServiceInte.queryCommentByQuestionId(id,0,0);

        //获取相关问题
        List<Question> relatedQuestions = questionServiceInte.queryRelatedQuestion(questions.get(0));

        //把格式换回来
        String tag = questions.get(0).getTag();
        tag = tag.replace('|',',');
        questions.get(0).setTag(tag);

        model.addAttribute("RELATEDQUESTIONS",relatedQuestions);
        model.addAttribute("QUESTION",questions.get(0));
        model.addAttribute("COMMENTS",comments);
        for (Comment comment:comments) {
            System.out.println(comment.getLikeCount());
        }
        return "question";
    }

    /**
     * 搜索问题
     * @param search
     * @return
     */
    @RequestMapping("search")
    public String searchQuestion(String search){
        //跳转至首页
        return "";
    }

}
