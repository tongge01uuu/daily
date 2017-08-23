package com.we.backend.track.domain.business.vo;

import com.we.backend.track.domain.business.po.WorkSheet;

/**
 * Created by yukai on 2017-8-23.
 */
public class WorkSheetVo extends WorkSheet{
    private String workerName;

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }
}
