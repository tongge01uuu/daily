package com.we.contract.util;

import java.io.Serializable;

/**
 * User:hgq
 * Datetime:2016/5/5 15:46
 */
public class ReturnData<T> implements Serializable {

    private static final long serialVersionUID = 1;

    private String message;

    private int status;

    private T data;

    protected ReturnData() {
        this.setMessage("成功");
        this.setStatus(0);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ReturnData<T> build() {
        return new ReturnData();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void withError(MsgConstants msg) {
        this.setStatus(msg.getCode());
        this.setMessage(msg.getMessage());
    }

    public void withError(int status, String msg) {
        this.setStatus(status);
        this.setMessage(msg);
    }
}
