/**
 * Copyright(c) 2010-2012 by Renrendai Inc.
 * All Rights Reserved
 */
package com.we.contract.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jinkai
 */
public enum ContractTemplateType {

    LOAN() {

        @Override
        public String toString() {
            return "交易合同";
        }
    },
    FINANCE_PLAN() {

        @Override
        public String toString() {
            return "理财计划合同";
        }
    },
    LOAN_TRANSFER() {
        @Override
        public String toString() {
            return "债权转让合同";
        }
    },
    OTHER() {

        @Override
        public String toString() {
            return "其他";
        }
    },
    FINANCE_PLAN_RSV() {

        @Override
        public String toString() {
            return "理财计划预定合同";
        }
    },
    UPLAN() {

        @Override
        public String toString() {
            return "U计划合同";
        }
    },
    UPLAN_RSV() {

        @Override
        public String toString() {
            return "U计划预定合同";
        }
    },
    AUTO_INVEST_PLAN() {

        @Override
        public String toString() {
            return "定投计划合同";
        }
    },
    LOAN_MOBILE(){

        @Override
        public String toString() {
            return "xproject移动端合同";
        }
    },
    FINANCE_PLAN_NEW(){

        @Override
        public String toString() {
            return "新优选合同";
        }
    },
    LOAN_TRANSFER_PX() {
        @Override
        public String toString() {
            return "债权转让合同（培训贷）";
        }
    };

    @Override
    public abstract String toString();

    public static Map<String,String> getAllTypes()
    {
        Map<String,String> map=new HashMap<>();
        for (ContractTemplateType cell:ContractTemplateType.values())
        {
            map.put(cell.name(),cell.toString());
        }
        return map;
    }

}
