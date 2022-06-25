package com.wuxianggujun.wuxiangblog.controller;

import cn.hutool.core.util.StrUtil;
import com.wuxianggujun.wuxiangblog.entity.User;
import com.wuxianggujun.wuxiangblog.result.Result;
import com.wuxianggujun.wuxiangblog.result.ResultGenerator;
import com.wuxianggujun.wuxiangblog.service.UserService;
import com.wuxianggujun.wuxiangblog.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("/user")
public class UserLoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping(value = "/register")
//    public Result registerUser(@RequestBody User user, HttpServletResponse response) {
//        Map<String, Object> map = userService.register(user);
//        return getResult(response, "注册成功!", map);
//    }

    //封装一下
    private Result getResult(HttpServletResponse response, String message, Map<String, Object> map) {
        if (map.containsKey("msg")) {
            return ResultGenerator.getFailResult((String) map.get("msg"));
        }
        if (map.containsKey("token")) {
            if (StrUtil.isNotBlank((map.get("token").toString()))) {
                //将token存入Http的header中
                response.setHeader(JWTUtils.header, (String) map.get("token"));
            }
        }
        return ResultGenerator.getSuccessResult(message, (User) map.get("user"));
    }

}
