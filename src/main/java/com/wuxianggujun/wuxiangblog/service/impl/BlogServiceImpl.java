package com.wuxianggujun.wuxiangblog.service.impl;

import com.wuxianggujun.wuxiangblog.entity.Blog;
import com.wuxianggujun.wuxiangblog.mapper.BlogMapper;
import com.wuxianggujun.wuxiangblog.pojo.SearchBlog;
import com.wuxianggujun.wuxiangblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogMapper blogDao;

    @Autowired
    public void setBlogDao(BlogMapper blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public List<Blog> listBlogs() {
        return null;
    }

    @Override
    public boolean deleteBlog(Long id) {
        return false;
    }

    @Override
    public List<SearchBlog> searchBlogs(SearchBlog searchBlog) {
        return blogDao.searchBlogs(searchBlog);
    }

    @Override
    public boolean addBlog(Blog blog) {
        return false;
    }

}
