package com.bbs.realm;

import com.bbs.pojo.User;
import com.bbs.service.inte.UserServiceInte;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserServiceInte userServiceInte;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("用户认证开始");

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //把传来的账号密码给user对象
        User user = new User();

        user.setAccountId(usernamePasswordToken.getUsername());

        user.setPassword(new String(usernamePasswordToken.getPassword()));

        User users = userServiceInte.login(user);
        //2、判断用户名称是否存在
        if (users == null) {
            //用户名称不存在，Shiro底层会抛出UnknowAccountException
            return null;
        }
        //3、判断密码是否正确
        return new SimpleAuthenticationInfo(users,users.getPassword(), this.getName());
    }
}
