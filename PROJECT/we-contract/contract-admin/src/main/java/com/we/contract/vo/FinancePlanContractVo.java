package com.we.contract.vo;

import com.we.contract.entity.FinancePlanContract;

/**
 * Created by yukai on 2017-9-11.
 */
public class FinancePlanContractVo extends FinancePlanContract {
    private String userName;
    private String financePlanName;
    private String subPointTypeName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFinancePlanName() {
        return financePlanName;
    }

    public void setFinancePlanName(String financePlanName) {
        this.financePlanName = financePlanName;
    }

    public String getSubPointTypeName() {
        return subPointTypeName;
    }

    public void setSubPointTypeName(String subPointTypeName) {
        this.subPointTypeName = subPointTypeName;
    }
}
