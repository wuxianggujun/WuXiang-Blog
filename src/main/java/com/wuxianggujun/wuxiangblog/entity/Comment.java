package com.wuxianggujun.wuxiangblog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 评论
 *
 * @author 无相孤君
 * @date 2022/06/17
 */
@TableName("t_comment")
public class Comment {
    /**
     * id
     */
    private Long id;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 内容
     */
    private String content;
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 《阿凡达》
     */
    private String avatar;
    /**
     * 创建时间
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 父评论id
     *///交流评论id，用来标识评论属于哪一个评论
    private Long parentCommentId;
    /**
     * 父母昵称
     */
    private String parentNickname;
    /**
     * 回复评论
     *///回复评论
    private List<Comment> replyComments = new ArrayList<>();
    /**
     * 父母评论
     */
    private Comment parentComment;//做扩展用，展示没有什么用，评论内容都存在了content字段中

    /**
     * 博客
     */
    //private DetailedBlog blog;
    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getParentNickname() {
        return parentNickname;
    }

    public void setParentNickname(String parentNickname) {
        this.parentNickname = parentNickname;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

//    public DetailedBlog getBlog() {
//        return blog;
//    }
//
//    public void setBlog(DetailedBlog blog) {
//        this.blog = blog;
//    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", blogId=" + blogId +
                ", parentCommentId=" + parentCommentId +
                ", parentNickname='" + parentNickname + '\'' +
                ", replyComments=" + replyComments +
                ", parentComment=" + parentComment +
                '}';
    }
}
