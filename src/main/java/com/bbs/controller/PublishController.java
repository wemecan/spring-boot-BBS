package com.bbs.controller;

import com.bbs.pojo.Question;
import com.bbs.pojo.User;
import com.bbs.service.inte.QuestionServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PublishController {
    @Autowired
    QuestionServiceInte questionServiceInte;

    /**
     * 跳转至 发布问题页面
     * @return
     */
    @RequestMapping("publish")
    public String doPublish(Model model){
        model.addAttribute("QUESTION",null);
        return "publish";
    }

    /**
     * 发布问题 提交
     * @param question
     * @return
     */
    @RequestMapping("addQuestion")
    public String addQuestion(Question question, HttpSession session){
        User user = (User)session.getAttribute("USER");
        question.setUser(user);
        int count = questionServiceInte.addQuestionOrUpdate(question);

        //成功跳转至问题界面
        if (count > 0){
            return "redirect:/question/"+question.getId();

        }else{
            return "publish";
        }
    }

    /**
     * 编辑问题文章
     * @param id
     * @return
     */
    @GetMapping("publish/{id}")
    public String updateQuestion(@PathVariable("id") Integer id, Model model,HttpSession session){

        List<Question> questionList = questionServiceInte.getQuestionById(0,0,id);

        //从session获取用户对象
        User uesr = (User)session.getAttribute("USER");
        //session保存的用户id 必须和 文章关联的用户id 一致
        if (uesr.getId() != questionList.get(0).getUser().getId()){
            return "/";
        }

        model.addAttribute("QUESTION",questionList.get(0));

        return "publish";
    }


}
