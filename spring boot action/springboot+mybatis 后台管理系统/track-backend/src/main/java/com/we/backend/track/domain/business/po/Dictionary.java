package com.we.backend.track.domain.business.po;

import java.util.Date;

public class Dictionary {
    private Integer id;

    /**
    * 名称
    */
    private String name;

    /**
    * 排序
    */
    private Integer order;

    /**
    * 类型 例如：流程节点
    */
    private Integer type;

    /**
    * 描述
    */
    private String description;

    private Date createTime;

    /**
    * 5.6.5+有效
    */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}