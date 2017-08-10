package com.we.backend.track.domain.vo;


import com.we.backend.track.domain.dto.PageDto;

import java.io.Serializable;
import java.util.Date;

public class RoleResource  extends PageDto implements Serializable {
    private Integer roleResId;

    private Integer roleId;

    private Integer resourceId;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifierTime;

    public Integer getRoleResId() {
        return roleResId;
    }

    public void setRoleResId(Integer roleResId) {
        this.roleResId = roleResId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifierTime() {
        return modifierTime;
    }

    public void setModifierTime(Date modifierTime) {
        this.modifierTime = modifierTime;
    }
}