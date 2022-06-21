package com.wuxianggujun.wuxiangblog.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.wuxianggujun.wuxiangblog.entity.User;
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
        Map<String, Object> map = new HashMap<String, Object>();
        //根据接受用户密码查询数据库
        User userDb = userDao.findUserByUserName(user.getUsername());
        //判断查询的用户数据不为null
        if (ObjectUtil.isNotNull(userDb)) {
            //再判断userdb与user的数据
            if (StrUtil.equals(userDb.getUsername(), user.getUsername()) && StrUtil.equals(userDb.getPassword(), user.getPassword())) {
                //将UserName存入token中
                String token = JWTUtils.createToken(userDb.getUsername());
                map.put("user", userDb);
                map.put("token", token);
            } else {
                map.put("user", userDb);
                map.put("result", "账号或者密码错误");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(user.toString());
        userDao.insertUser(user);
        return map;
    }

}
