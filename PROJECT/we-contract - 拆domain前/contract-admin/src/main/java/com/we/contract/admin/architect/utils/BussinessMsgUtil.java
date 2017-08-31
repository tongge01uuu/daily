package com.we.contract.admin.architect.utils;

import com.we.contract.admin.architect.constant.BussinessCode;
import com.we.contract.admin.domain.system.bo.ResultEntity;

/**
 * 后台管理系统返回码信息帮助类
 *
 * @author YK
 * @date 2017/7/11
 */

public class BussinessMsgUtil {


    /**
     * 返回消息代码code 和 message
     *
     * @param bussinessCode 返回码
     * @return
     */
    public static ResultEntity returnCodeMessage(BussinessCode bussinessCode) {
        return returnCodeMessage(bussinessCode, null);
    }

    /**
     * 返回消息代码和数据
     *
     * @param bussinessCode 返回码
     * @param returnData    返回数据
     * @return
     */
    public static ResultEntity returnCodeMessage(BussinessCode bussinessCode, Object returnData) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setCode(bussinessCode.getCode());
        resultEntity.setMessage(bussinessCode.getMsg());
        resultEntity.setData(returnData);
        return resultEntity;
    }
}
