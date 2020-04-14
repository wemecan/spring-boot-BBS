package com.bbs.Filter;

import com.bbs.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 记住我功能过滤器
 */
public class RememberMeFilter extends FormAuthenticationFilter {

    /**
     * 记住我功能的过滤器。解决丢失session的问题
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        //得到主体
        Subject subject = SecurityUtils.getSubject();
        //得到session
        Session session = subject.getSession();
        if (!subject.isAuthenticated() && subject.isRemembered() && session.getAttribute("USER") == null){
            User user = (User)subject.getPrincipal();
            session.setAttribute("USER",user);
        }
        return true;
    }
}
