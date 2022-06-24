package com.wuxianggujun.wuxiangblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuxianggujun.wuxiangblog.entity.User;
import com.wuxianggujun.wuxiangblog.mapper.BlogMapper;
import com.wuxianggujun.wuxiangblog.mapper.UserMapper;
import com.wuxianggujun.wuxiangblog.pojo.SearchBlog;
import com.wuxianggujun.wuxiangblog.service.BlogService;
import com.wuxianggujun.wuxiangblog.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, SearchBlog> implements BlogService {
    private BlogMapper blogDao;


    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setBlogDao(BlogMapper blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public List<UserVo> searchBlog(String title) {

        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).eq(User::getUsername, title);
        //先查询用户数据
        User user = userMapper.selectOne(wrapper);

        List<UserVo> searchBlogs = new ArrayList<>();//blogDao.selectList(queryWrapper);
        searchBlogs.add();
        return searchBlogs;
    }
}
