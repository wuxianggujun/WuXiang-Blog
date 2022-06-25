package com.wuxianggujun.wuxiangblog.controller;

import com.wuxianggujun.wuxiangblog.entity.Blog;
import com.wuxianggujun.wuxiangblog.result.Result;
import com.wuxianggujun.wuxiangblog.result.ResultGenerator;
import com.wuxianggujun.wuxiangblog.service.BlogService;
import com.wuxianggujun.wuxiangblog.service.SearchBlogService;
import com.wuxianggujun.wuxiangblog.entity.vo.SearchBlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    //博客Service
    private BlogService blogService;
    //搜索Service
    private SearchBlogService searchBlogService;

    @Autowired
    public void setSearchBlogService(SearchBlogService searchBlogService) {
        this.searchBlogService = searchBlogService;
    }


    @Autowired
    public void setBlogDao(BlogService blogDao) {
        this.blogService = blogDao;
    }

    @GetMapping("/{id}/delete")
    public Result delete(@PathVariable Long id) {
        return null;
    }


    @PostMapping("/search")
    public Result search(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestParam String title) {
        List<SearchBlogVo> searchBlogs = searchBlogService.searchBlogs(title);
        return ResultGenerator.getSuccessResult(searchBlogs);
    }

    @PostMapping("/{id}/update")
    public Result update(@RequestBody Blog blog) {
        return null;
    }

}
