package com.wuxianggujun.wuxiangblog.mapper;

import com.wuxianggujun.wuxiangblog.pojo.SearchBlog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {

//    List<SearchBlog> listBlogs(SearchBlog searchBlog);
    List<SearchBlog> searchBlogs(SearchBlog searchBlog);


}
