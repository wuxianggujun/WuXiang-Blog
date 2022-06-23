package com.wuxianggujun.wuxiangblog;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WuXiangBlogApplication.class);
    }

    /**
     * 监听器：监听HTTP请求事件
     * 解决RequestContextHolder.getRequestAttributes()空指针问题
     *
     * @return
     */
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
