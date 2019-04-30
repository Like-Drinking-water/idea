package com.huanleichen.idea.common.domain;

import javax.persistence.*;

@Table(name = "idea_service_radios.idea_radio")
public class IdeaRadio extends BaseDomain {
    private static final long serialVersionUID = 697193770853188444L;
    /**
     * 广播编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 广播名称
     */
    private String name;

    /**
     * 关注人数
     */
    @Column(name = "concern_number")
    private Integer concernNumber;

    /**
     * 文章数目
     */
    @Column(name = "post_number")
    private Integer postNumber;

    /**
     * 广播公告
     */
    private String announcement;

    /**
     * 封面
     */
    private String cover;

    /**
     * 获取广播编码
     *
     * @return id - 广播编码
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置广播编码
     *
     * @param id 广播编码
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取广播名称
     *
     * @return name - 广播名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置广播名称
     *
     * @param name 广播名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取关注人数
     *
     * @return concern_number - 关注人数
     */
    public Integer getConcernNumber() {
        return concernNumber;
    }

    /**
     * 设置关注人数
     *
     * @param concernNumber 关注人数
     */
    public void setConcernNumber(Integer concernNumber) {
        this.concernNumber = concernNumber;
    }

    /**
     * 获取文章数目
     *
     * @return post_number - 文章数目
     */
    public Integer getPostNumber() {
        return postNumber;
    }

    /**
     * 设置文章数目
     *
     * @param postNumber 文章数目
     */
    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }


    /**
     * 获取广播公告
     *
     * @return announcement - 广播公告
     */
    public String getAnnouncement() {
        return announcement;
    }

    /**
     * 设置广播公告
     *
     * @param announcement 广播公告
     */
    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}