package com.wuxianggujun.wuxiangblog.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.StrUtil;
import com.wuxianggujun.wuxiangblog.result.Result;
import com.wuxianggujun.wuxiangblog.result.ResultGenerator;
import com.wuxianggujun.wuxiangblog.service.UserService;
import com.wuxianggujun.wuxiangblog.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 验证码的逻辑
     *
     * @param response
     * @param session
     * @throws IOException
     */
    @GetMapping("/login/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        //验证码对象
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 20);
        //放入到session
        session.setAttribute("code", lineCaptcha.getCode());
        //输出验证码
        ServletOutputStream outputStream = response.getOutputStream();
        lineCaptcha.write(outputStream);
        //关闭输出流
        outputStream.close();
    }

    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password, String code, HttpSession session, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        //首先判断验证码正不正确
        String sessionCode = (String) session.getAttribute("code");
        //比较两个字符串大小写不敏感
        if (StrUtil.isNotBlank(code) && StrUtil.equalsIgnoreCase(sessionCode, code)) {
            map = userService.login(username, password);
            //如果登录中穿回错误信息就先输出
            if (map.containsKey("error")) {
                return ResultGenerator.getFailResult((String) map.get("error"));
            }
            response.setHeader(JWTUtils.header, (String) map.get("token"));
        } else {
            return ResultGenerator.getFailResult("验证码错误");
        }
        return ResultGenerator.getSuccessResult("登陆成功!", map.get("User"));
    }

    @PostMapping("/register")
    public Result register(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> map = userService.register(username, password);
        if (map.containsKey("error")) {
            return ResultGenerator.getFailResult((String) map.get("error"));
        }
        return ResultGenerator.getSuccessResult("注册成功！", map.get("user"));
    }


}
