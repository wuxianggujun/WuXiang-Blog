package com.wuxianggujun.wuxiangblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuxianggujun.wuxiangblog.entity.vo.SearchBlogVo;
import com.wuxianggujun.wuxiangblog.mapper.SearchBlogMapper;
import com.wuxianggujun.wuxiangblog.service.SearchBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchBlogServiceImpl extends ServiceImpl<SearchBlogMapper, SearchBlogVo> implements SearchBlogService {

    private SearchBlogMapper searchBlogDao;

    @Autowired
    public void setSearchBlogDao(SearchBlogMapper searchBlogDao) {
        this.searchBlogDao = searchBlogDao;
    }

    @Override
    public List<SearchBlogVo> searchBlogs(String title) {
        QueryWrapper<SearchBlogVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(SearchBlogVo::getTitle, "文章");
        List<SearchBlogVo> searchBlogVos = searchBlogDao.searchBlogs(queryWrapper);
        System.out.println(searchBlogVos.toString());
        return searchBlogVos;
    }


}
