package com.bbs.controller;

import com.bbs.pojo.User;
import com.bbs.service.inte.NotifictionServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 通知控制器
 */
@Controller
public class NotifictionController {

    @Autowired
    private NotifictionServiceInte notifictionServiceInte;

    /**
     * 修改通知状态
     * @param notificationId
     * @param questionId
     * @return
     */
    @RequestMapping("read/{notificationId}/{questionId}")
    public String read(@PathVariable("notificationId")Integer notificationId, @PathVariable("questionId")Integer questionId, Integer commentId, HttpSession session){



        int count = notifictionServiceInte.readNotifiction(notificationId);

        if (count > 0 ){

            //修改通知的数量
            //获取用户信息
            User user = (User) session.getAttribute("USER");
            int unReadCount = notifictionServiceInte.getUnreadNotifier(user.getId());
            session.setAttribute("UNREADNOTIFIER",unReadCount);

            //跳转到那个评论
            if (commentId != null && commentId > 0){

                return "redirect:/question/"+questionId+"#comment_location"+commentId;

            }else{

                return "redirect:/question/"+questionId;
            }


        }

        return "redirect:/";
    }

}
