package com.wuxianggujun.wuxiangblog.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wuxianggujun.wuxiangblog.vo.SearchBlogVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper extends BaseMapper<SearchBlogVo> {

    //查询文章
    List<SearchBlogVo> list(@Param(Constants.WRAPPER) QueryWrapper<SearchBlogVo> ew);

}
