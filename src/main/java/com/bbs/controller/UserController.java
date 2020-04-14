package com.bbs.controller;

import com.bbs.pojo.Notifiction;
import com.bbs.pojo.PageDTO;
import com.bbs.pojo.Question;
import com.bbs.pojo.User;
import com.bbs.service.inte.NotifictionServiceInte;
import com.bbs.service.inte.QuestionServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    QuestionServiceInte questionServiceInte;

    //通知业务逻辑层接口
    @Autowired
    private NotifictionServiceInte notifictionServiceInte;
    /**
     * 跳转到个人中心 并进行分类 获取用户的问题列表
     * @param type
     * @return
     */
    @RequestMapping("people/{type}")
    public String doUser(@PathVariable("type") String type, PageDTO page, HttpSession session, Model model){
        //从session中获取用户对象
        User user = (User)session.getAttribute("USER");
        List<Question> questions = null;
        //通知未读数量
        int notifiCount = 0;
        //根据用户查询通知
        List<Notifiction> notifictions = notifictionServiceInte.queryNotifiction(user.getId());

        if ("myQuestion".equals(type)){
            model.addAttribute("TYPE","我的问题");
            questions = questionServiceInte.getQuestionById(user.getId(),page.getPage(),0);
            //获取全部问题列表
            page.setQuestions(questionServiceInte.getAllQuestion(9999,null));
            page.count();  //计算出有多少页
            page.quesListSize();
            page.showOrhide();

        }else if ("mine".equals(type)){
            model.addAttribute("TYPE","我的资料");
        }else if ("notifiction".equals(type)){

            model.addAttribute("NOTIFICTION_LIST",notifictions);
            model.addAttribute("TYPE","我的通知");

        }
        //获取出通知未读的数量
        for (Notifiction notifiction: notifictions
        ) {
            System.out.println(notifiction.getOuterId());
            if (notifiction.getStatus() == 0){
                notifiCount++;
            }

        }
        model.addAttribute("NOTIFI_COUNT",notifiCount);

        //把分页文章存入请求作用域
        model.addAttribute("QUESTION_LIST",questions);
        model.addAttribute("PAGE_LIST",page.getPages());

        return "people";
    }
    /**
     * 跳转到个人中心
     * @return
     */
    @RequestMapping("people")
    public String doUser(){

        return "redirect:/people/myQuestion";
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String userLogout(HttpSession session){
        session.removeAttribute("USER");
        session.removeAttribute("UNREADNOTIFIER");

        return "redirect:/";
    }



}
