package com.we.backend.track.domain.vo;

import com.we.backend.track.domain.dto.PageDto;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

public class Resource  extends PageDto implements Serializable {
    private Integer resId;

    private Integer resParentid;

    private String resName;

    private Integer resStatus;

    /**
    * 模块标识
    */
    private String resModelCode;

    private String resLinkAddress;

    private String resImage;

    private Integer resType;

    private Integer resDisplayOrder;

    private String resRemark;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifyTime;

    private boolean checked=false;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getResParentid() {
        return resParentid;
    }

    public void setResParentid(Integer resParentid) {
        this.resParentid = resParentid;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public Integer getResStatus() {
        return resStatus;
    }

    public void setResStatus(Integer resStatus) {
        this.resStatus = resStatus;
    }

    public String getResModelCode() {
        return resModelCode;
    }

    public void setResModelCode(String resModelCode) {
        this.resModelCode = resModelCode;
    }

    public String getResLinkAddress() {
        return resLinkAddress;
    }

    public void setResLinkAddress(String resLinkAddress) {
        this.resLinkAddress = resLinkAddress;
    }

    public String getResImage() {
        return resImage;
    }

    public void setResImage(String resImage) {
        this.resImage = resImage;
    }

    public Integer getResType() {
        return resType;
    }

    public void setResType(Integer resType) {
        this.resType = resType;
    }

    public Integer getResDisplayOrder() {
        return resDisplayOrder;
    }

    public void setResDisplayOrder(Integer resDisplayOrder) {
        this.resDisplayOrder = resDisplayOrder;
    }

    public String getResRemark() {
        return resRemark;
    }

    public void setResRemark(String resRemark) {
        this.resRemark = resRemark;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}