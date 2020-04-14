package com.bbs.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.util.DigestUtils;

/**
 * md5加密工具类
 */
public class Md5Util {
    //盐，用于混交md5
    private static final String slat = "&%5123***&&%%$$#@";

    public static void main(String[] args) {
        //System.out.println(getMD5("123456"));
    }
    /**
     * 生成md5
     * @param str
     * @return
     */
    public static String getMD5(String str) {

        return new Md5Hash(str, slat, 1024).toString();
    }
}
