package com.wuxianggujun.wuxiangblog.service.impl;

import com.wuxianggujun.wuxiangblog.entity.Blog;
import com.wuxianggujun.wuxiangblog.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Override
    public List<Blog> listBlogs() {
        return null;
    }

    @Override
    public boolean deleteBlog(Long id) {
        return false;
    }

    @Override
    public List<Blog> searchBlogs() {
        return null;
    }

    @Override
    public boolean addBlog(Blog blog) {
        return false;
    }

}
