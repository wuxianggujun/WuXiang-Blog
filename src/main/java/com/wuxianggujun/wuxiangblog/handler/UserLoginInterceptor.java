package com.wuxianggujun.wuxiangblog.handler;

import com.alibaba.fastjson.JSON;
import com.wuxianggujun.wuxiangblog.exception.ApiException;
import com.wuxianggujun.wuxiangblog.result.ResultGenerator;
import com.wuxianggujun.wuxiangblog.util.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录处理程序拦截器,拦截所有请求
 *
 * @author 无相孤君
 * @date 2022/06/19
 */
//@Component
public class UserLoginInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //目标方法执行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            //handler 可能是RequestResourceHandle springboot 访问静态资源默认去classpath下的static目录
            return true;
        }
        //http的header中获取token
        String token = request.getHeader(JWTUtils.header);
        logger.info("=====================Request Start==========================");
        String requestUri = request.getRequestURI();
        logger.info("request uri:{}", requestUri);
        logger.info("request method:{}", request.getMethod());
        logger.info("token:{}", token);
        logger.info("=====================Request End==========================");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().print(JSON.toJSON(ResultGenerator.getSuccessResult()));
        //token不存在
        if (token == null || token.equals("")) throw new ApiException("请先登录");
        //验证token
        String sub = JWTUtils.validateToken(token);
        if (sub == null || sub.equals(""))
            throw new ApiException("token验证失败");
        //更新token有效时间（如果需要更新其实就是产生一个新的token）
        if (JWTUtils.isNeedUpdate(token)) {
            String newToken = JWTUtils.createToken(sub);
            response.setHeader(JWTUtils.header, newToken);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
