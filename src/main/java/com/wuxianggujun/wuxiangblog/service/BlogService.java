package com.wuxianggujun.wuxiangblog.service;

import com.wuxianggujun.wuxiangblog.entity.Blog;
import com.wuxianggujun.wuxiangblog.pojo.SearchBlog;

import java.util.List;

public interface BlogService {
    //获取博客列表
    List<Blog> listBlogs();
   //删除博客
    boolean deleteBlog(Long id);
   //搜索博客
    List<SearchBlog> searchBlogs(SearchBlog searchBlog);

    //新增博客
    boolean addBlog(Blog blog);

}
