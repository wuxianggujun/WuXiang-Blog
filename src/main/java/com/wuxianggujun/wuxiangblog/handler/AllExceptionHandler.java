package com.wuxianggujun.wuxiangblog.handler;

import com.wuxianggujun.wuxiangblog.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author 无相孤君
 * @date 2022/06/19
 *///对加了controller注解的东西，进行拦截处理，aop实现
@ControllerAdvice
public class AllExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(AllExceptionHandler.class);

    //进行异常处理，处理Exception.class的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody//返回json数据
    public Result doException(Exception ex) {
        ex.printStackTrace();
        return Result.fail(-999, "系统异常");
    }

}
