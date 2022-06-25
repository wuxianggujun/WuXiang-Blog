package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_blog
 */
@TableName(value ="t_blog")
public class TBlog implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Boolean appreciation;

    /**
     * 
     */
    private Boolean commentabled;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private String firstPicture;

    /**
     * 
     */
    private String flag;

    /**
     * 
     */
    private Boolean published;

    /**
     * 
     */
    private Boolean recommend;

    /**
     * 
     */
    private Boolean shareStatement;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer views;

    /**
     * 
     */
    private Long typeId;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Integer commentCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     */
    public Boolean getAppreciation() {
        return appreciation;
    }

    /**
     * 
     */
    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
    }

    /**
     * 
     */
    public Boolean getCommentabled() {
        return commentabled;
    }

    /**
     * 
     */
    public void setCommentabled(Boolean commentabled) {
        this.commentabled = commentabled;
    }

    /**
     * 
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     */
    public String getFirstPicture() {
        return firstPicture;
    }

    /**
     * 
     */
    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    /**
     * 
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 
     */
    public Boolean getPublished() {
        return published;
    }

    /**
     * 
     */
    public void setPublished(Boolean published) {
        this.published = published;
    }

    /**
     * 
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * 
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * 
     */
    public Boolean getShareStatement() {
        return shareStatement;
    }

    /**
     * 
     */
    public void setShareStatement(Boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    /**
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 
     */
    public Integer getViews() {
        return views;
    }

    /**
     * 
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TBlog other = (TBlog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppreciation() == null ? other.getAppreciation() == null : this.getAppreciation().equals(other.getAppreciation()))
            && (this.getCommentabled() == null ? other.getCommentabled() == null : this.getCommentabled().equals(other.getCommentabled()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getFirstPicture() == null ? other.getFirstPicture() == null : this.getFirstPicture().equals(other.getFirstPicture()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getPublished() == null ? other.getPublished() == null : this.getPublished().equals(other.getPublished()))
            && (this.getRecommend() == null ? other.getRecommend() == null : this.getRecommend().equals(other.getRecommend()))
            && (this.getShareStatement() == null ? other.getShareStatement() == null : this.getShareStatement().equals(other.getShareStatement()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getViews() == null ? other.getViews() == null : this.getViews().equals(other.getViews()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCommentCount() == null ? other.getCommentCount() == null : this.getCommentCount().equals(other.getCommentCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppreciation() == null) ? 0 : getAppreciation().hashCode());
        result = prime * result + ((getCommentabled() == null) ? 0 : getCommentabled().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getFirstPicture() == null) ? 0 : getFirstPicture().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getPublished() == null) ? 0 : getPublished().hashCode());
        result = prime * result + ((getRecommend() == null) ? 0 : getRecommend().hashCode());
        result = prime * result + ((getShareStatement() == null) ? 0 : getShareStatement().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getViews() == null) ? 0 : getViews().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCommentCount() == null) ? 0 : getCommentCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appreciation=").append(appreciation);
        sb.append(", commentabled=").append(commentabled);
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", description=").append(description);
        sb.append(", firstPicture=").append(firstPicture);
        sb.append(", flag=").append(flag);
        sb.append(", published=").append(published);
        sb.append(", recommend=").append(recommend);
        sb.append(", shareStatement=").append(shareStatement);
        sb.append(", title=").append(title);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", views=").append(views);
        sb.append(", typeId=").append(typeId);
        sb.append(", userId=").append(userId);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}