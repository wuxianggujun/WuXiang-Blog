package com.wuxianggujun.wuxiangblog.service.impl;

import com.wuxianggujun.wuxiangblog.entity.User;
import com.wuxianggujun.wuxiangblog.exception.ApiException;
import com.wuxianggujun.wuxiangblog.mapper.UserMapper;
import com.wuxianggujun.wuxiangblog.service.UserService;
import com.wuxianggujun.wuxiangblog.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional//事务注解
public class UserServiceImpl implements UserService {

    private UserMapper userDao;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userDao = userMapper;
    }

    @Override
    public Map<String, Object> login(User user) {
        //根据接受用户密码查询数据库
        User userDb = userDao.queryByName(user.getUsername());
        if (userDb == null) {
            //注册用户
            int count = userDao.add(user);
            if (count < 1) throw new ApiException("注册异常!");
        }
        //将id存入token中
        String token = JWTUtils.createToken(userDb.getId().toString());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", userDb);
        map.put("token", token);
        return map;
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }

}
