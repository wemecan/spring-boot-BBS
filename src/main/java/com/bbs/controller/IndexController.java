package com.bbs.controller;

import com.bbs.pojo.PageDTO;
import com.bbs.pojo.Question;
import com.bbs.service.inte.CommentServiceInte;
import com.bbs.service.inte.QuestionServiceInte;
import com.bbs.service.inte.UserServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 首页控制器
 */
@Controller
public class IndexController {

    //用户业务逻辑层
    @Autowired
    UserServiceInte userServiceInte;

    //问题业务逻辑层
    @Autowired
    QuestionServiceInte questionServiceInte;
    //评论业务逻辑层接口
    @Autowired
    private CommentServiceInte commentServiceInte;
    /**
     * 跳转至首页
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, PageDTO page,String search){
        List<Question> questions;
        //获取全部文章   9999 = 获取全部
        List<Question> questionAllList = questionServiceInte.getAllQuestion(9999,search);

        if (page.getPage() == 0){
            //获取分页第一页文章
            questions = questionServiceInte.getAllQuestion(1,search);

            page.setQuestions(questionAllList);

            page.count();  //计算出有多少页
            page.quesListSize();
            page.showOrhide();
        }else{

            questions = questionServiceInte.getAllQuestion(page.getPage(),search);

            page.setQuestions(questionAllList);

            page.setQuestions(questionAllList);
            page.count();  //计算出有多少页
            page.quesListSize();
            page.showOrhide();
        }
        //System.out.println(commentServiceInte.queryReplyCountById(0,1));
        //循环获取各问题的评论数
        for (Question question:questions) {
            int count = commentServiceInte.queryReplyCountById(0,question.getId(),0);
            question.setCommentCount(count);
        }

        //把分页文章存入请求作用域
        model.addAttribute("QUESTION_LIST",questions);
        model.addAttribute("PAGE_LIST",page.getPages());
        //把搜索的存进请求作用域
        if (search != null && search != ""){
            model.addAttribute("SEARCH",search);
        }

        return "index";

    }



}
