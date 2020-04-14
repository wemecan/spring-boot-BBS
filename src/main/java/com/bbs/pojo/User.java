package com.bbs.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 */
@Data
public class User implements Serializable {
    private int id;
    private String nickName;
    private String accountId;  //登录用户名
    private String password;  //登录密码
    private String sex;
    private String face;  //头像连接
    private String regTime;  //注册时间
    private String email;  //邮箱
    private String mobile;  //手机号码

}
