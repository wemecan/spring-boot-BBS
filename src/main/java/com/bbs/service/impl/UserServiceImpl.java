package com.bbs.service.impl;

import com.bbs.mapper.UserMapper;
import com.bbs.pojo.User;
import com.bbs.service.inte.UserServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInte {


    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers() {

        return userMapper.getUsers();
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
