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
    /**
     * id类型
     */
    private Long typeId;


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }


    @Override
    public String toString() {
        return "SearchBlog{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
