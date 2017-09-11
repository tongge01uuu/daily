/**
 * Copyright(c) 2010-2012 by Renrendai Inc.
 * All Rights Reserved
 */
package com.we.contract.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jinkai
 */
public enum SubPointType {

    FINANCE_PLAN() {

        @Override
        public String toString() {
            return "U计划";
        }
    },
    AUTO_INVEST_PLAN() {

        @Override
        public String toString() {
            return "薪计划";
        }
    };

    @Override
    public abstract String toString();

    public static Map<String,String> getAllTypes()
    {
        Map<String,String> map=new HashMap<>();
        for (SubPointType cell: SubPointType.values())
        {
            map.put(cell.name(),cell.toString());
        }
        return map;
    }

}
