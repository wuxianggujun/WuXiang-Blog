package com.wuxianggujun.wuxiangblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuxianggujun.wuxiangblog.mapper.SearchBlogMapper;
import com.wuxianggujun.wuxiangblog.service.SearchBlogService;
import com.wuxianggujun.wuxiangblog.vo.SearchBlogVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchBlogServiceImpl extends ServiceImpl<SearchBlogMapper, SearchBlogVo> implements SearchBlogService {

    @Override
    public List<SearchBlogVo> searchBlogs(String title) {

        return null;
    }
}
