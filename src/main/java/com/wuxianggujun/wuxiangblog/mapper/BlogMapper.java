package com.wuxianggujun.wuxiangblog.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuxianggujun.wuxiangblog.pojo.SearchBlog;
import com.wuxianggujun.wuxiangblog.vo.SearchBlogVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BlogMapper extends BaseMapper<SearchBlog> {

    String querySql = "select tb.id ,tb.create_time ,tb.recommend ,tb.title ,tb.type_id ,tt.id ,tt.name  from wuxiangblog.t_blog tb ,wuxiangblog.t_type tt; ";


    //分页查询
    @Select(querySql)
    Page<SearchBlog> page(@Param("page") Page page, @Param("ew") Wrapper queryWrapper);

    //普通查询
    //@Select(querySql)
    List<SearchBlogVo> list(@Param("ew") Wrapper queryWrapper);


}
