package com.wuxianggujun.wuxiangblog.pojo;


import java.io.Serializable;

/**
 * 搜索博客
 * 搜索博客实体类
 *
 * @author 无相孤君
 * @date 2022/06/22
 */
public class SearchBlog implements Serializable {
    /**
     * 标题
     */
    private String title;

    private String name;

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
