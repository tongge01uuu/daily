package com.we.backend.track.domain.business.po;

import java.util.Date;

public class WorkSheet {
    private Integer id;

    /**
    * 用户流程状态记录id
    */
    private Integer stateId;

    /**
    * 后台工作人员id
    */
    private Integer userBackendId;

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

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getUserBackendId() {
        return userBackendId;
    }

    public void setUserBackendId(Integer userBackendId) {
        this.userBackendId = userBackendId;
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