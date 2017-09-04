package com.we.contract.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.contract.architect.constant.BussinessCode;
import com.we.contract.constant.ContractTemplateType;
import com.we.contract.service.ContractTemplateService;
import com.we.contract.util.ResultEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yukai on 2017-9-4.
 */
@Controller
@RequestMapping("contract/")
public class ContractTemplateController {
    private static Logger logger= LoggerFactory.getLogger(ContractTemplateController.class);
    @Autowired
    private ContractTemplateService contractTemplateService;


    public String toString()
    {

    }


    @ResponseBody
    @RequestMapping("list")
    public ResultEntity list(Integer pageNum,Integer pageSize,String templateType)
    {
        ResultEntity resultEntity = ResultEntity.build();
        try {
            PageHelper.startPage(pageNum,pageSize);
            ContractTemplateType contractTemplateType=null;
            if (StringUtils.isNotBlank(templateType))
            {
                contractTemplateType=ContractTemplateType.valueOf(templateType);
            }
            List list=contractTemplateService.list(contractTemplateType);
            PageInfo pageInfo=new PageInfo(list);
            resultEntity.setData(pageInfo);
        } catch (IllegalArgumentException e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            resultEntity.withError(BussinessCode.GLOBAL_ERROR.getMsg());
        }
        return resultEntity;
    }
}
