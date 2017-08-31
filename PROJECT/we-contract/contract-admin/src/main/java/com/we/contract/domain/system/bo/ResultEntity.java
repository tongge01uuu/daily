package com.we.contract.domain.system.bo;

import com.we.contract.architect.constant.BussinessCode;

import java.io.Serializable;

/**
 * 后台管理系统业务返回Message通用类
 *
 * @author YK
 * @date 2017/7/11
 */


public class ResultEntity implements Serializable {
    //返回Code
    private String code;
    //返回描述
    private String message;
    //返回数据
    private Object data;

    private final static String SUCCESS="SUCCESS";

    public static ResultEntity build(String returnCode, String returnMessage)
    {
        return new ResultEntity(returnCode,returnMessage);
    }
    public static ResultEntity build(BussinessCode bussinessCode)
    {
        return new ResultEntity(bussinessCode.getCode(),bussinessCode.getMsg());
    }
    public static ResultEntity build()
    {
        return new ResultEntity(BussinessCode.GLOBAL_SUCCESS.getCode(),BussinessCode.GLOBAL_SUCCESS.getMsg());
    }
    public ResultEntity withError(String returnMessage)
    {
        this.setCode(BussinessCode.GLOBAL_ERROR.getCode());
        this.setMessage(returnMessage);
        return this;
    }
    public ResultEntity withError(BussinessCode bussinessCode)
    {
        this.setCode(bussinessCode.getCode());
        this.setMessage(bussinessCode.getMsg());
        return this;
    }





    public ResultEntity(){}

    private ResultEntity(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
