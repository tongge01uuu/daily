package com.we.backend.track.domain.business.po;

import java.util.Date;

public class Dictionary {
    private Integer id;

    /**
    * 为0时属于类别
    */
    private Integer pid;

    /**
    * 名称
    */
    private String name;

    /**
    * 排序
    */
    private Integer orderWeight;

    /**
    * 类型 (备用)
    */
    private Integer type;

    /**
    * 描述
    */
    private String description;

    /**
    * 开关 0-失效 1-生效
    */
    private Integer access;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(Integer orderWeight) {
        this.orderWeight = orderWeight;
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

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
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