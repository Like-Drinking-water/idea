package com.huanleichen.idea.common.domain;

import javax.persistence.*;

@Table(name = "idea_service_page_content.idea_page_content")
public class IdeaPageContent extends BaseDomain {
    private static final long serialVersionUID = 5580029173904337115L;
    /**
     * 内容编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 内容类型（1.海报 2.小广告）
     */
    private Byte type;

    /**
     * 内容路径
     */
    private String path;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取内容编号
     *
     * @return id - 内容编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置内容编号
     *
     * @param id 内容编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取内容类型（1.海报 2.小广告）
     *
     * @return type - 内容类型（1.海报 2.小广告）
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置内容类型（1.海报 2.小广告）
     *
     * @param type 内容类型（1.海报 2.小广告）
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取内容路径
     *
     * @return path - 内容路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置内容路径
     *
     * @param path 内容路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}