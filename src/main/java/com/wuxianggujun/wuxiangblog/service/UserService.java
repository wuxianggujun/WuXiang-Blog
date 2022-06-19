package com.wuxianggujun.wuxiangblog.service;

import com.wuxianggujun.wuxiangblog.entity.User;

import java.util.Map;

public interface UserService {
    //登录
    Map<String, Object> login(User user);

    //注册
    void register(User user);
}
