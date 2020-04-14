package com.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.bbs.mapper")
public class JavabbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavabbsApplication.class, args);
    }

}
