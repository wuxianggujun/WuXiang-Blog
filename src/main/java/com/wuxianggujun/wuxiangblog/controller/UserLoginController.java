package com.wuxianggujun.wuxiangblog.controller;

import com.wuxianggujun.wuxiangblog.entity.User;
import com.wuxianggujun.wuxiangblog.result.Result;
import com.wuxianggujun.wuxiangblog.result.ResultGenerator;
import com.wuxianggujun.wuxiangblog.service.UserService;
import com.wuxianggujun.wuxiangblog.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/register")
    public Result registerUser(User user) {
        userService.register(user);
        return ResultGenerator.getSuccessResult(user);
    }

    @GetMapping(value = "/status")
    public Result status() {
        return ResultGenerator.getSuccessResult();
    }

    @GetMapping("/login")
    public Result login(User user, HttpServletResponse response) {
        Map<String, Object> map = userService.login(user);
        //将token存入Http的header中
        response.setHeader(JWTUtils.USER_LOGIN_TOKEN, (String) map.get("token"));
        return ResultGenerator.getSuccessResult((User) map.get("user"));
    }

    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Map<String, Object> map = userService.login(user);
        return ResultGenerator.getSuccessResult((User) map.get("user"));
    }


}
