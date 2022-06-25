package com.wuxianggujun.wuxiangblog.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wuxianggujun.wuxiangblog.vo.SearchBlogVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchBlogMapper extends BaseMapper<SearchBlogVo> {
    //查询文章
    List<SearchBlogVo> searchBlogs(@Param(Constants.WRAPPER) QueryWrapper<SearchBlogVo> ew);

}
