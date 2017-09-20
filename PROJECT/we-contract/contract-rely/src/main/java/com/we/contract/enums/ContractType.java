package com.we.contract.enums;

import com.we.contract.entity.BorrowContract;
import com.we.contract.entity.FinancePlanContract;
import com.we.contract.entity.LoanTransferContract;

/**
 * Created by yukai on 2017-9-18.
 */
public enum ContractType {
    FINANCE_PLAN("finance_plan_contract", FinancePlanContract.class.getName(),"U计划合同记录"),
    LOAN_TRANSFER("loan_transfer_contract", LoanTransferContract.class.getName(),"标的合同记录"),
    BORROW("borrow_contract", BorrowContract.class.getName(),"借款合同记录")
    ;


    private String table;
    private String className;
    private String description;

    ContractType(String table, String className, String description) {
        this.table = table;
        this.className = className;
        this.description = description;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
