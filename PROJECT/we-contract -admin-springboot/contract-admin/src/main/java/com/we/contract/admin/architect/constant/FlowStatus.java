package com.we.contract.admin.architect.constant;

/**
 * Created by yukai on 2017-8-22.
 */
public enum FlowStatus {
    UN_FINISHED(0,"未完成"),
    FINISHED(1,"已完成");

    private int key;
    private String description;

    FlowStatus(int key,String description)
    {
        this.key=key;
        this.description=description;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
