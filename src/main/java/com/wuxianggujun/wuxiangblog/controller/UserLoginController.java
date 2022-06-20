package com.wuxianggujun.wuxiangblog.controller;

import com.wuxianggujun.wuxiangblog.entity.User;
import com.wuxianggujun.wuxiangblog.result.Result;
import com.wuxianggujun.wuxiangblog.result.ResultGenerator;
import com.wuxianggujun.wuxiangblog.service.UserService;
import com.wuxianggujun.wuxiangblog.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@Controller
@RestController
public class UserLoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result registerUser(User user) {
        userService.register(user);
        return ResultGenerator.getSuccessResult(user);
    }

    @GetMapping(value = "/status")
    public Result status() {
        return ResultGenerator.getSuccessResult();
    }

    @GetMapping("/user/login")
    public Result login(User user, HttpServletResponse response) {
        Map<String, Object> map = userService.login(user);
        //将token存入Http的header中
        response.setHeader(JWTUtils.USER_LOGIN_TOKEN, (String) map.get("token"));
        return ResultGenerator.getSuccessResult((User) map.get("user"));
    }

    @PostMapping("/user/login")
    public Result login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Map<String, Object> map = userService.login(user);
        return ResultGenerator.getSuccessResult((User) map.get("user"));
    }


}
