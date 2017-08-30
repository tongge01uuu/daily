package com.we.p2p.util.cache;


public class RedisAccessException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 5013856973217112170L;

    public RedisAccessException() {
        super();
    }

    public RedisAccessException(String msg) {
        super(msg);
    }

    public RedisAccessException(Throwable cause) {
        super(cause);
    }

    public RedisAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
