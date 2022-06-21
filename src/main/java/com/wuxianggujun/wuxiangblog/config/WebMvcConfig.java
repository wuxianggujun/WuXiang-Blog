package com.wuxianggujun.wuxiangblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web mvc配置
 *
 * @author 无相孤君
 * @date 2022/06/19
 */
@Configuration
@ComponentScan("com.wuxianggujun.wuxiangblog")//全局异常处理类需要被扫描才可以
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截test接口，后续需要拦截的接口时，在配置
        //registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/user/login");
    }

    //    /**
//     * 添加拦截器
//     *
//     * @param registry 注册表
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new UserLoginInterceptor())
//                .addPathPatterns("/user/**")
//                .excludePathPatterns("/user/login", "/user/register");//开放登录路径
//    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
//                .allowCredentials(true)
//                .maxAge(3600)
//                .allowedHeaders("*");
//    }


}
