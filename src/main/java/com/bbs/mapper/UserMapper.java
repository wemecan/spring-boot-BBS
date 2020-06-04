package com.bbs.mapper;

import com.bbs.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public List<User> getUsers();

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

}
