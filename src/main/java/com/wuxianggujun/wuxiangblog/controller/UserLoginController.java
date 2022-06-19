package com.wuxianggujun.wuxiangblog.controller;

import com.alibaba.druid.util.StringUtils;
import com.wuxianggujun.wuxiangblog.entity.User;
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

//    @PostMapping(value = "/login")
//    //@RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
//        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
//            session.setAttribute("loginUser", username);
//            return "redirect:/index";
//        }
//        return "redirect:/login";
//    }
//    @Override
//    public Map<String,Object> login(User user) {
//        //phone是除id外的唯一标志 需要进行检查
//        if (user.getPhone() == null || user.getPhone().equals(""))
//            throw new ApiException("手机号不合法");
//        User selectUser = userDao.selectUserByPhone(user.getPhone());
//        if (selectUser == null) {
//            //注册用户
//            int count = userDao.insertUser(user);
//            if (count < 1) throw new ApiException(ResultInfo.serviceUnavailable("注册异常"));
//        }
//        //将userId存入token中
//        String token = JWTUtils.createToken(selectUser.getUserId().toString());
//        Map<String,Object> map = new HashMap<>();
//        map.put("user",selectUser);
//        map.put("token",token);
//        return map;
//    }
//
    @GetMapping("/user/login")
    public ResultInfo login(User user, HttpServletResponse response) {
        Map<String, Object> map = userService.login(user);
        //将token存入Http的header中
        response.setHeader(JWTUtils.USER_LOGIN_TOKEN, (String) map.get("token"));
        return ResultInfo.success((User)map.get("user"));
    }


}
