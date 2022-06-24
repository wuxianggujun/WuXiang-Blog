package com.wuxianggujun.wuxiangblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuxianggujun.wuxiangblog.entity.Blog;
import com.wuxianggujun.wuxiangblog.entity.User;
import com.wuxianggujun.wuxiangblog.pojo.SearchBlog;
import com.wuxianggujun.wuxiangblog.vo.UserVo;

import java.util.List;

public interface BlogService extends IService<SearchBlog> {

    List<UserVo> searchBlog(String title);


}
