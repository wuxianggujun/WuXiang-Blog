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
     * @param username
     * @param password
     * @return
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
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();
        //查询用户名，判断存不存在
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getUsername, user.getUsername());
        User userDb = userDao.selectOne(userQueryWrapper);
        //User userDb = userDao.findUserByUserName(user.getUsername());
        if (ObjectUtil.isNotNull(userDb)) {
            map.put("msg", "用户已经存在");
            return map;
        }
        if (StrUtil.isNotEmpty(user.getUsername()) && StrUtil.isNotEmpty(user.getPassword())) {
            //密码加密
            String password = user.getPassword();
            String digestHex = DigestUtil.md5Hex(password);
            user.setPassword(digestHex);
            //还需要创建注册时间

            int rows = userDao.insert(user);
            if (rows < 1) {
                map.put("msg", "数据插入失败！");
                return map;
            }
            //将UserName存入token中
            String token = JWTUtils.createToken(user.getUsername());
            map.put("user", user);
            map.put("token", token);
        } else {
            map.put("msg", "用户名或密码不能为null");
        }
        return map;
    }

}
