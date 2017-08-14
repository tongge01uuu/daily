package com.we.backend.track.domain.system.bo;

import com.we.backend.track.architect.constant.BussinessCode;

import java.io.Serializable;

/**
 * 后台管理系统业务返回Message通用类
 *
 * @author YK
 * @date 2017/7/11
 */


public class ResultEntity implements Serializable {
    //返回Code
    private String returnCode;
    //返回描述
    private String returnMessage;
    //返回数据
    private Object returnData;

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
        this.setReturnCode(BussinessCode.GLOBAL_ERROR.getCode());
        this.setReturnMessage(returnMessage);
        return this;
    }
    public ResultEntity withError(BussinessCode bussinessCode)
    {
        this.setReturnCode(bussinessCode.getCode());
        this.setReturnMessage(bussinessCode.getMsg());
        return this;
    }





    public ResultEntity(){}

    private ResultEntity(String returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public Object getReturnData() {
        return returnData;
    }

    public void setReturnData(Object returnData) {
        this.returnData = returnData;
    }
}
