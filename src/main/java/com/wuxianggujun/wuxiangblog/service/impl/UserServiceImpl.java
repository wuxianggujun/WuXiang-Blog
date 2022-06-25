package com.wuxianggujun.wuxiangblog.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuxianggujun.wuxiangblog.entity.User;
import com.wuxianggujun.wuxiangblog.mapper.UserMapper;
import com.wuxianggujun.wuxiangblog.service.UserService;
import com.wuxianggujun.wuxiangblog.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private UserMapper userDao;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userDao = userMapper;
    }

    /**
     * 使用用户名密码登录
     */
    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        //先将密码加密，不然不相等
        String digestHex = DigestUtil.md5Hex(password);
        //查询数据库中的用户名和密码
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getUsername, username);
        userQueryWrapper.lambda().eq(User::getPassword, digestHex);
        User user = userDao.selectOne(userQueryWrapper);
        if (ObjectUtil.isNull(user)) {
            map.put("error", "用户名或者密码错误!");
            return map;
        }
        //将UserName存入token中
        String token = JWTUtils.createToken(user.getUsername());
        map.put("user", user);
        map.put("token", token);
        map.put("msg", "用户登录成功！");
        return map;
    }

    @Override
    public Map<String, Object> register(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        if (StrUtil.isNotEmpty(username) && StrUtil.isNotEmpty(password)) {
            //查询用户名，判断存不存在
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.lambda().eq(User::getUsername, username);
            User userDb = userDao.selectOne(userQueryWrapper);
            if (ObjectUtil.isNotNull(userDb)) {
                map.put("error", "用户已经存在");
                return map;
            }
            //密码加密
            String digestHex = DigestUtil.md5Hex(password);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            User user = new User();
            user.setUsername(username);
            user.setPassword(digestHex);
            user.setCreateTime(LocalDateTime.now());
            int rows = userDao.insert(user);
            if (rows < 1) {
                map.put("error", "数据插入失败！");
                return map;
            }
            map.put("user", user);
        } else {
            map.put("error", "用户名或密码不能为null");
        }
        return map;
    }

}
