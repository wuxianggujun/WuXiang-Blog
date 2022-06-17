package com.wuxianggujun.wuxiangblog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 消息
 *
 * @author 无相孤君
 * @date 2022/06/17
 */
public class Message {
    /**
     * id
     */
    private Long id;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 内容
     */
    private String content;
    /**
     * 《阿凡达》
     */
    private String avatar;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 父母消息id
     */
    private Long parentMessageId;
    /**
     * 管理信息
     */
    private boolean adminMessage;

    /**
     * 回复消息
     */
    private List<Message> replyMessages = new ArrayList<Message>();
    /**
     * 父母信息
     */
    private Message parentMessage;
    /**
     * 父母昵称
     */
    private String parentNickname;


    public Message() {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getParentMessageId() {
        return parentMessageId;
    }

    public void setParentMessageId(Long parentMessageId) {
        this.parentMessageId = parentMessageId;
    }

    public boolean isAdminMessage() {
        return adminMessage;
    }

    public void setAdminMessage(boolean adminMessage) {
        this.adminMessage = adminMessage;
    }

    public List<Message> getReplyMessages() {
        return replyMessages;
    }

    public void setReplyMessages(List<Message> replyMessages) {
        this.replyMessages = replyMessages;
    }

    public Message getParentMessage() {
        return parentMessage;
    }

    public void setParentMessage(Message parentMessage) {
        this.parentMessage = parentMessage;
    }

    public String getParentNickname() {
        return parentNickname;
    }

    public void setParentNickname(String parentNickname) {
        this.parentNickname = parentNickname;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", parentMessageId=" + parentMessageId +
                ", adminMessage=" + adminMessage +
                ", replyMessages=" + replyMessages +
                ", parentMessage=" + parentMessage +
                ", parentNickname='" + parentNickname + '\'' +
                '}';
    }
}
