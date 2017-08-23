package com.we.backend.track.domain.business.vo;

import com.we.backend.track.domain.business.po.UserFlowState;

/**
 * Created by yukai on 2017-8-23.
 */
public class UserFlowStateVo extends UserFlowState{
    private String flowName;
    private String workerName;

    public String getWorkerName() {
        return workerName;
    }
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }
}
