package com.wuxianggujun.wuxiangblog.controller;

import com.wuxianggujun.wuxiangblog.entity.Blog;
import com.wuxianggujun.wuxiangblog.pojo.SearchBlog;
import com.wuxianggujun.wuxiangblog.result.Result;
import com.wuxianggujun.wuxiangblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }

    @PostMapping("/{id}/update")
    public Result update(@RequestBody Blog blog) {
        return null;
    }

}
