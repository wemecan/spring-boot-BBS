package com.bbs.controller;

import com.bbs.pojo.User;
import com.bbs.service.inte.NotifictionServiceInte;
import com.bbs.service.inte.UserServiceInte;
import com.bbs.utils.Md5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserServiceInte userServiceInte;

    //通知业务逻辑层
    @Autowired
    private NotifictionServiceInte notifictionServiceInte;
    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("loginUser")
    public String login(User user,boolean rememberMe, HttpSession session, Model model){

        //传来的密码加密
        String md5Password = Md5Util.getMD5(user.getPassword());
        //把加密的密码再次 赋值到 user对象
        user.setPassword(md5Password);

        //1、获取 Subject
        Subject subject = SecurityUtils.getSubject();
        //2、封装用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getAccountId(), user.getPassword(),rememberMe);
        //3、执行登录方法
        try {
            subject.login(usernamePasswordToken);
            //获取用户对象
            User use = (User)subject.getPrincipal();
            session.setAttribute("USER",use);
            //获取通知的数量
            int count = notifictionServiceInte.getUnreadNotifier(use.getId());
            session.setAttribute("UNREADNOTIFIER",count);
            return "redirect:/";
        } catch (UnknownAccountException e) {//该异常用户名称不存在
            //登录失败，用户名称不存在
            model.addAttribute("msg", "用户名称不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {//该异常密码错误
            //登录失败，密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        }

    }

    /**
     * 跳转至登陆界面
     * @return
     */
    @RequestMapping("login")
    public String doLogin(){
        return "login";
    }

}
