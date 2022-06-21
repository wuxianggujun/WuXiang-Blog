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
            return map;
        }
        map.put("result", "用户不存在");
        return map;
    }

    @Override
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询用户名，判断存不存在
        User userDb = userDao.findUserByUserName(user.getUsername());
        if (ObjectUtil.isNotNull(userDb)) {
            map.put("result", "用户已经存在");
            return map;
        }
        if (StrUtil.isNotEmpty(user.getUsername()) && StrUtil.isNotEmpty(user.getPassword())) {
            //密码加密
            String password = user.getPassword();
            user.setPassword("123456789");
            int rows = userDao.insertUser(user);
            if (rows < 1) {
                map.put("result", "数据插入失败！");
                return map;
            }
            //将UserName存入token中
            String token = JWTUtils.createToken(user.getUsername());
            map.put("user", user);
            map.put("token", token);
        } else {
            map.put("result", "用户名或密码不能为null");
        }
        return map;
    }

}
