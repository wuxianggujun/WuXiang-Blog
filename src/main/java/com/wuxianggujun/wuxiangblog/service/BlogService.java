package com.wuxianggujun.wuxiangblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuxianggujun.wuxiangblog.entity.Blog;

import java.util.Map;

public interface BlogService extends IService<Blog> {
   Map<String,Object> input(Blog blog, String token);
}
