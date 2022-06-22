package com.wuxianggujun.wuxiangblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuxianggujun.wuxiangblog.entity.Blog;
import com.wuxianggujun.wuxiangblog.pojo.SearchBlog;
import com.wuxianggujun.wuxiangblog.result.Result;
import com.wuxianggujun.wuxiangblog.result.ResultGenerator;
import com.wuxianggujun.wuxiangblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public void setBlogDao(BlogService blogDao) {
        this.blogService = blogDao;
    }

    @GetMapping("/{id}/delete")
    public Result delete(@PathVariable Long id) {
        return null;
    }


    @PostMapping("/search")
    public Result search(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestBody SearchBlog searchBlog) {
        //分页插件,返回分页数据
        List<SearchBlog> blogs = blogService.searchBlogs(searchBlog);
        PageHelper.startPage(pageNum, 10);
        PageInfo<SearchBlog> pageInfo = new PageInfo<>(blogs);
        return ResultGenerator.getSuccessResult(pageInfo);
    }

    @PostMapping("/{id}/update")
    public Result update(@RequestBody Blog blog) {
        return null;
    }

}
