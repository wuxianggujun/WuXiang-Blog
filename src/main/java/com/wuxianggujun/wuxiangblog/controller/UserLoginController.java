package com.wuxianggujun.wuxiangblog.controller;

import com.alibaba.druid.util.StringUtils;
import com.wuxianggujun.wuxiangblog.entity.User;
import com.wuxianggujun.wuxiangblog.pojo.Result;
import com.wuxianggujun.wuxiangblog.pojo.ResultInfo;
import com.wuxianggujun.wuxiangblog.service.UserService;
import com.wuxianggujun.wuxiangblog.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

//@Controller
@RestController
public class UserLoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/register",produces = MediaType.APPLICATION_JSON_VALUE)
    public Result registerUser(User user){
        userService.register(user);
        return Result.success(user);
    }

    @GetMapping("/user/login")
    public Result login(User user, HttpServletResponse response) {
        Map<String, Object> map = userService.login(user);
        //将token存入Http的header中
        response.setHeader(JWTUtils.USER_LOGIN_TOKEN, (String) map.get("token"));
        return Result.success((User)map.get("user"));
    }
    @PostMapping ("/user/login")
    public Result login(String username,String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        Map<String, Object> map = userService.login(user);
        return Result.success((User)map.get("user"));
    }


}
