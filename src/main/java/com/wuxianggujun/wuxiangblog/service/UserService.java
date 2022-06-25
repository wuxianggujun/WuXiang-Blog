package com.wuxianggujun.wuxiangblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuxianggujun.wuxiangblog.entity.User;

import java.util.Map;

public interface UserService extends IService<User> {
    //登录
    Map<String, Object> login(String username,String password);

    //注册
    Map<String,Object> register(String username,String password);


}
