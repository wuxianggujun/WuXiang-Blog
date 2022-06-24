package com.wuxianggujun.wuxiangblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuxianggujun.wuxiangblog.mapper.BlogMapper;
import com.wuxianggujun.wuxiangblog.service.BlogService;
import com.wuxianggujun.wuxiangblog.vo.SearchBlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, SearchBlogVo> implements BlogService {
    private BlogMapper blogDao;

    @Autowired
    public void setBlogDao(BlogMapper blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public List<SearchBlogVo> searchBlog(String title) {

        QueryWrapper<SearchBlogVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(SearchBlogVo::getTitle,"文章");

        List<SearchBlogVo> searchBlogVos = blogDao.list(queryWrapper);

//
//        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).eq(User::getUsername, title);
//        //先查询用户数据
//        User user = userMapper.selectOne(wrapper);

        return searchBlogVos;
    }
}
