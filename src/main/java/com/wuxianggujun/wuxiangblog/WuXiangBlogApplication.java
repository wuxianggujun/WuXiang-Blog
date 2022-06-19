package com.wuxianggujun.wuxiangblog;

import com.wuxianggujun.wuxiangblog.util.JWTUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wuxianggujun.wuxiangblog.mapper")
public class WuXiangBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuXiangBlogApplication.class, args);
    }


}
