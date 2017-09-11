package com.we.contract.controller;

import com.we.contract.constant.SubPointType;
import com.we.contract.controller.basic.BasicController;
import com.we.contract.entity.FinancePlanContract;
import com.we.contract.service.FinancePlanContractService;
import com.we.contract.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by yukai on 2017-9-11.
 */
@Controller
@RequestMapping("contract/financePlan")
public class FinancePlanContractController extends BasicController {
    @Autowired
    private FinancePlanContractService financePlanContractService;

    @RequestMapping("toList.do")
    public String toList(Model model)
    {
        Map subPointTypes= SubPointType.getAllTypes();
        model.addAttribute("subPointTypes",subPointTypes);
        return "contract/contract_finance_plan_list";
    }

    public ResultEntity list(FinancePlanContract financePlanContract)
    {
        ResultEntity resultEntity=ResultEntity.build();
        return resultEntity;
    }

}
