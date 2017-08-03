package com.springboot.web.websocket.broadcast;

/**
 * Created by yukai on 2017/7/19.
 */
public class Greeting {
    private String from;
    private String to;
    private String message;

    /**
     * 无参数构造函数必须不能省掉，不然前端向后端传参序列化失败
     */
    public Greeting() {
    }

    public Greeting(String from, String message, String to) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
