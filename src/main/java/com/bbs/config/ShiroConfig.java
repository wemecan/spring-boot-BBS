package com.bbs.config;

import com.bbs.Filter.RememberMeFilter;
import com.bbs.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 创建shiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager,RememberMeFilter rememberMeFilter) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置Shiro过滤器
        /**
         * 内置Shiro过滤器实现相关拦截功能
         *      常用的过滤器有：
         *          anon  : 无需认证（登录）可以访问
         *          authc : 必须认证才能访问
         *          user  : 如果使用rememberMe的功能可以直接访问
         *          perms : 该资源必须得到资源访问权限才可以使用
         *          role  : 该资源必须得到角色授权才可以使用
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login", "anon");
        filterMap.put("/", "anon");
        filterMap.put("/loginUser", "anon");
        filterMap.put("/question/*", "anon");
        //静态资源
        filterMap.put("/static/**", "anon");
        filterMap.put("/images/**","anon");
        filterMap.put("/css/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/json/**","anon");
        filterMap.put("/admin/**","anon");  //后台首页
        //filterMap.put("/publish","user");
        //filterMap.put("/createComment","user");
        filterMap.put("/**", "rememberMe,user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl("/login");
        //配置记住我自定义过滤器
        Map<String, Filter> filter = new HashMap<>();
        filter.put("rememberMe",rememberMeFilter);
        shiroFilterFactoryBean.setFilters(filter);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        securityManager.setRealm(userRealm);
        //注入记住我管理器
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean
    public UserRealm getRealm() {
        return new UserRealm();
    }

    /**
     * cookie对象;
     * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
        //System.out.println("ShiroConfiguration.rememberMeCookie()");
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间7天 ,单位秒;-->
        simpleCookie.setMaxAge(25200);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        //System.out.println("ShiroConfiguration.rememberMeManager()");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }
    @Bean
    public RememberMeFilter getRememberMeFilter(){
        return new RememberMeFilter();
    }
}
