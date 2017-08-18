package com.we.backend.track.domain.business.po;

import java.util.Date;

public class UserFlowState {
    private Integer id;

    /**
    * 用户id
    */
    private Integer userId;

    /**
    * 真实姓名
    */
    private String realName;

    /**
    * 手机号
    */
    private String mobile;

    /**
    * 民生回调返回数据
    */
    private String stateInput;

    /**
    * order_id
    */
    private String orderId;

    /**
    * 流程节点id
    */
    private Integer flowId;

    /**
    * 流程节点状态 0-未完成 1-已完成
    */
    private Integer flowStatus;

    /**
    * 客服处理状态 0-未处理 1-处理中 2-已回访
    */
    private Integer handleState;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStateInput() {
        return stateInput;
    }

    public void setStateInput(String stateInput) {
        this.stateInput = stateInput;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(Integer flowStatus) {
        this.flowStatus = flowStatus;
    }

    public Integer getHandleState() {
        return handleState;
    }

    public void setHandleState(Integer handleState) {
        this.handleState = handleState;
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