package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 后台控制器
 */
@Controller
public class AdminController {

    /**
     * 进入后台首页
     * @return
     */
    @GetMapping("admin")
    public String doAdmin(){

        return "admin/index";
    }

    /**
     * main 网页
     * @return
     */
    @GetMapping("admin/doMain")
    public String doMain(){

        return "admin/page/main";
    }

    /**
     * 跳转 newsList.html
     * @return
     */
    @GetMapping("admin/newsList")
    public String doNewsList(){

        return "admin/page/news/newsList";
    }

}
