package com.bbs.service.inte;

import com.bbs.pojo.User;

import java.util.List;

public interface UserServiceInte {

    public List<User> getUsers();
    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);
}
