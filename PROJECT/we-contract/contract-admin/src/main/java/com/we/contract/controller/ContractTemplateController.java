package com.we.contract.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.contract.architect.constant.BussinessCode;
import com.we.contract.constant.ContractTemplateType;
import com.we.contract.entity.ContractTemplate;
import com.we.contract.service.ContractTemplateService;
import com.we.contract.util.ResultEntity;
import com.we.contract.vo.ContractTemplateVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yukai on 2017-9-4.
 */
@Controller
@RequestMapping("contract/")
public class ContractTemplateController {
    private static Logger logger= LoggerFactory.getLogger(ContractTemplateController.class);
    @Autowired
    private ContractTemplateService contractTemplateService;


    @RequestMapping("/to/list.do")
    public String toList(Model model)
    {
        //模板类型
        Map<String,String> types=ContractTemplateType.getAllTypes();
        model.addAttribute("types",types);
        return "contract/contract_template_list";
    }


    @ResponseBody
    @RequestMapping("list.do")
    public ResultEntity list(Integer pageNum,Integer pageSize,String type,Model model)
    {
        model.addAttribute("type",type);
        ResultEntity resultEntity = ResultEntity.build();
        try {
            PageHelper.startPage(pageNum,pageSize,true);
            ContractTemplateType contractTemplateType=null;
            if (StringUtils.isNotBlank(type))
            {
                contractTemplateType=ContractTemplateType.valueOf(type);
            }
            List<ContractTemplate> list=contractTemplateService.list(contractTemplateType);
            PageInfo pageInfo=new PageInfo(list);
            List<ContractTemplateVo> voList=new ArrayList();
            for (ContractTemplate contractTemplate:list)
            {
                voList.add(new ContractTemplateVo(contractTemplate));
            }
            pageInfo.setList(voList);
            resultEntity.setData(pageInfo);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            resultEntity.withError(BussinessCode.GLOBAL_ERROR.getMsg());
        }
        return resultEntity;
    }

    @RequestMapping("toSaveOrUpdate.do")
    public String toSaveOrUpdate(Integer id,Model model)
    {
        if (id!=null)
        {
            try {
                ContractTemplate contractTemplate=contractTemplateService.get(id);
                model.addAttribute("contractTemplate",contractTemplate);
            } catch (Exception e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }
        }
        //模板类型
        Map<String,String> types=ContractTemplateType.getAllTypes();
        model.addAttribute("types",types);
        return "contract/contract_template_edit";
    }
    @ResponseBody
    @RequestMapping("saveOrUpdate.do")
    public ResultEntity saveOrUpdate(ContractTemplate contractTemplate)
    {
        ResultEntity resultEntity = ResultEntity.build();
        try {
            if (contractTemplate.getId()!=null)
            {
                // update
                contractTemplateService.update(contractTemplate);
            }else{
                // save
                contractTemplateService.save(contractTemplate);
            }
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            resultEntity.withError(BussinessCode.GLOBAL_ERROR.getMsg());
        }
        return resultEntity;
    }
    @ResponseBody
    @RequestMapping("fail.do")
    public ResultEntity fail(Integer id)
    {
        ResultEntity resultEntity = ResultEntity.build();
        try {
            Integer[] param={id};
            contractTemplateService.batchUpdateStatus(param,false);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            resultEntity.withError(BussinessCode.GLOBAL_ERROR.getMsg());
        }
        return resultEntity;
    }
    @ResponseBody
    @RequestMapping("fail/batch.do")
    public ResultEntity batchFail(@RequestParam("ids[]")Integer[] ids)
    {
        ResultEntity resultEntity = ResultEntity.build();
        try {
            contractTemplateService.batchUpdateStatus(ids,false);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            resultEntity.withError(BussinessCode.GLOBAL_ERROR.getMsg());
        }
        return resultEntity;
    }

    @RequestMapping("to/show.do")
    public void show(Integer id, HttpServletResponse response)
    {
        try {
            ContractTemplate contractTemplate=contractTemplateService.get(id);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println(contractTemplate.getContent());
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
    }


}
