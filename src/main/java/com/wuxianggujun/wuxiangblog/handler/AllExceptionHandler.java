package com.wuxianggujun.wuxiangblog.handler;

import com.wuxianggujun.wuxiangblog.exception.ApiException;
import com.wuxianggujun.wuxiangblog.result.Result;
import com.wuxianggujun.wuxiangblog.result.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
        logger.error(ex.getMessage());
        ex.printStackTrace();
        return ResultGenerator.getFailResult(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ApiException.class)
    public Result handler(ApiException ex) {
        return ResultGenerator.getFailResult(ex.getMessage());
    }

}
