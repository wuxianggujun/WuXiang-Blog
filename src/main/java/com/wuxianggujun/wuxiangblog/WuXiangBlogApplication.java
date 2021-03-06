package com.wuxianggujun.wuxiangblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@MapperScan("com.wuxianggujun.wuxiangblog.mapper")
public class WuXiangBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuXiangBlogApplication.class, args);
    }

}
