package com.we.contract.architect.constant;

/**
 * Created by yukai on 2017-8-22.
 */
public enum HandleStatus {
    UN_HANDLE(0,"未处理"),
    HANDLING(1,"处理中"),
    DONE(2,"已回访");

    private int key;
    private String description;

    HandleStatus(int key,String description)
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
