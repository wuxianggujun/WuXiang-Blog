package com.wuxianggujun.wuxiangblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuxianggujun.wuxiangblog.entity.vo.SearchBlogVo;

import java.util.List;

public interface SearchBlogService extends IService<SearchBlogVo> {
    List<SearchBlogVo> searchBlogs(String title);
}
