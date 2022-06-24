package com.wuxianggujun.wuxiangblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuxianggujun.wuxiangblog.pojo.SearchBlog;
import com.wuxianggujun.wuxiangblog.vo.SearchBlogVo;

import java.util.List;

public interface BlogService extends IService<SearchBlog> {

    List<SearchBlogVo> searchBlog(String title);


}
