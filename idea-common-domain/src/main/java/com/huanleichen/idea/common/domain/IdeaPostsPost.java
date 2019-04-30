package com.huanleichen.idea.common.domain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "idea_service_posts.idea_posts_post")
public class IdeaPostsPost extends BaseDomain {
    private static final long serialVersionUID = 7355210352492647978L;
    /**
     * 文章编码
     */
    @Id
    @Column(name = "post_guid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String postGuid;

    /**
     * 文章发布时间
     */
    @Column(name = "time_published")
    private Date timePublished;

    /**
     * 文章状态（0已发布的文章 1待审核的文章 2允许刊登）
     */
    private String status;

    /**
     * 文章所发表的广播地址
     */
    @Column(name = "post_adress")
    private Integer postAdress;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章作者
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 封面缩略图片
     */
    @Column(name = "thumb_image")
    private String thumbImage;

    /**
     * 被赞数
     */
    @Column(name = "number_of_upvotes")
    private Integer numberOfUpvotes;

    /**
     * 被踩数
     */
    @Column(name = "number_of_downvotes")
    private Integer numberOfDownvotes;

    /**
     * 被阅读数
     */
    @Column(name = "number_of_reads")
    private Integer numberOfReads;

    /**
     * 被分享数
     */
    @Column(name = "number_of_shares")
    private Integer numberOfShares;

    /**
     * 被添加实现列表数
     */
    @Column(name = "number_of_bookmarks")
    private Integer numberOfBookmarks;

    /**
     * 被评论数
     */
    @Column(name = "number_of_comments")
    private Integer numberOfComments;

    /**
     * 文章审核被拒理由
     */
    @Column(name = "reject_msg")
    private String rejectMsg;

    /**
     * 点赞数
     */
    @Column(name = "like_num")
    private Integer likeNum;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 获取文章编码
     *
     * @return post_guid - 文章编码
     */
    public String getPostGuid() {
        return postGuid;
    }

    /**
     * 设置文章编码
     *
     * @param postGuid 文章编码
     */
    public void setPostGuid(String postGuid) {
        this.postGuid = postGuid;
    }

    /**
     * 获取文章发布时间
     *
     * @return time_published - 文章发布时间
     */
    public Date getTimePublished() {
        return timePublished;
    }

    /**
     * 设置文章发布时间
     *
     * @param timePublished 文章发布时间
     */
    public void setTimePublished(Date timePublished) {
        this.timePublished = timePublished;
    }

    /**
     * 获取文章状态（0已发布的文章 1待审核的文章 2允许刊登）
     *
     * @return status - 文章状态（0已发布的文章 1待审核的文章 2允许刊登）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置文章状态（0已发布的文章 1待审核的文章 2允许刊登）
     *
     * @param status 文章状态（0已发布的文章 1待审核的文章 2允许刊登）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取文章所发表的广播地址
     *
     * @return post_adress - 文章所发表的广播地址
     */
    public Integer getPostAdress() {
        return postAdress;
    }

    /**
     * 设置文章所发表的广播地址
     *
     * @param postAdress 文章所发表的广播地址
     */
    public void setPostAdress(Integer postAdress) {
        this.postAdress = postAdress;
    }

    /**
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取文章作者
     *
     * @return user_name - 文章作者
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置文章作者
     *
     * @param userName 文章作者
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取封面缩略图片
     *
     * @return thumb_image - 封面缩略图片
     */
    public String getThumbImage() {
        return thumbImage;
    }

    /**
     * 设置封面缩略图片
     *
     * @param thumbImage 封面缩略图片
     */
    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    /**
     * 获取被赞数
     *
     * @return number_of_upvotes - 被赞数
     */
    public Integer getNumberOfUpvotes() {
        return numberOfUpvotes;
    }

    /**
     * 设置被赞数
     *
     * @param numberOfUpvotes 被赞数
     */
    public void setNumberOfUpvotes(Integer numberOfUpvotes) {
        this.numberOfUpvotes = numberOfUpvotes;
    }

    /**
     * 获取被踩数
     *
     * @return number_of_downvotes - 被踩数
     */
    public Integer getNumberOfDownvotes() {
        return numberOfDownvotes;
    }

    /**
     * 设置被踩数
     *
     * @param numberOfDownvotes 被踩数
     */
    public void setNumberOfDownvotes(Integer numberOfDownvotes) {
        this.numberOfDownvotes = numberOfDownvotes;
    }

    /**
     * 获取被阅读数
     *
     * @return number_of_reads - 被阅读数
     */
    public Integer getNumberOfReads() {
        return numberOfReads;
    }

    /**
     * 设置被阅读数
     *
     * @param numberOfReads 被阅读数
     */
    public void setNumberOfReads(Integer numberOfReads) {
        this.numberOfReads = numberOfReads;
    }

    /**
     * 获取被分享数
     *
     * @return number_of_shares - 被分享数
     */
    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    /**
     * 设置被分享数
     *
     * @param numberOfShares 被分享数
     */
    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    /**
     * 获取被添加实现列表数
     *
     * @return number_of_bookmarks - 被添加实现列表数
     */
    public Integer getNumberOfBookmarks() {
        return numberOfBookmarks;
    }

    /**
     * 设置被添加实现列表数
     *
     * @param numberOfBookmarks 被添加实现列表数
     */
    public void setNumberOfBookmarks(Integer numberOfBookmarks) {
        this.numberOfBookmarks = numberOfBookmarks;
    }

    /**
     * 获取被评论数
     *
     * @return number_of_comments - 被评论数
     */
    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    /**
     * 设置被评论数
     *
     * @param numberOfComments 被评论数
     */
    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    /**
     * 获取文章审核被拒理由
     *
     * @return reject_msg - 文章审核被拒理由
     */
    public String getRejectMsg() {
        return rejectMsg;
    }

    /**
     * 设置文章审核被拒理由
     *
     * @param rejectMsg 文章审核被拒理由
     */
    public void setRejectMsg(String rejectMsg) {
        this.rejectMsg = rejectMsg;
    }


    /**
     * 获取点赞数
     *
     * @return like_num - 点赞数
     */
    public Integer getLikeNum() {
        return likeNum;
    }

    /**
     * 设置点赞数
     *
     * @param likeNum 点赞数
     */
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**
     * 获取文章摘要
     *
     * @return summary - 文章摘要
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置文章摘要
     *
     * @param summary 文章摘要
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取文章内容
     *
     * @return content - 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文章内容
     *
     * @param content 文章内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}