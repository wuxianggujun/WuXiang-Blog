package com.wuxianggujun.wuxiangblog.controller;

import com.alibaba.druid.util.StringUtils;
import com.wuxianggujun.wuxiangblog.entity.User;
import com.wuxianggujun.wuxiangblog.pojo.Result;
import com.wuxianggujun.wuxiangblog.pojo.ResultInfo;
import com.wuxianggujun.wuxiangblog.service.UserService;
import com.wuxianggujun.wuxiangblog.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserLoginController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/register")
    public Result registerUser(User user){
        return Result.success(user);
    }

    @GetMapping("/user/login")
    public Result login(User user, HttpServletResponse response) {
        Map<String, Object> map = userService.login(user);
        //将token存入Http的header中
        response.setHeader(JWTUtils.USER_LOGIN_TOKEN, (String) map.get("token"));
        return Result.success((User)map.get("user"));
    }


}
