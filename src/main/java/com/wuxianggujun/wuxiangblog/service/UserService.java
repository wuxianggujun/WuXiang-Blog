package com.wuxianggujun.wuxiangblog.service;

import com.wuxianggujun.wuxiangblog.entity.User;

import java.util.Map;

public interface UserService {
    Map<String,Object> login(User user);
}
