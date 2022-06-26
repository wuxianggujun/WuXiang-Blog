package com.wuxianggujun.wuxiangblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuxianggujun.wuxiangblog.entity.Blog;
import com.wuxianggujun.wuxiangblog.mapper.BlogMapper;
import com.wuxianggujun.wuxiangblog.mapper.UserMapper;
import com.wuxianggujun.wuxiangblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    private BlogMapper blogDao;
    private UserMapper userDao;

    @Autowired
    public void setUserDao(UserMapper userDao) {
        this.userDao = userDao;
    }


    @Autowired
    public void setBlogDao(BlogMapper blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public Map<String, Object> input(Blog blog, String token) {
        Map<String, Object> map = new HashMap<>();
//        //验证token拿到用户名和密码
//        String username = JWTUtils.validateToken(token);
//        //通过查询得到user对象
//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.lambda().eq(User::getUsername, username);
//
//        User user = userDao.selectOne(userQueryWrapper);
//
//        blog.setUser(user);
//        blog.setUserId(user.getId());
        blog.setCreateTime(LocalDateTime.now());

        int rows = blogDao.insert(blog);
        if (rows > 0) {
            map.put("msg", "博客插入成功！");
            map.put("result", blog);
            return map;
        }
        map.put("error", "博客插入失败！");
        map.put("result", blog);
        return map;
    }
}
