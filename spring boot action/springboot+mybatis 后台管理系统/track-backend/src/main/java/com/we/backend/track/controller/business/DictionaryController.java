package com.we.backend.track.controller.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.backend.track.domain.business.po.Dictionary;
import com.we.backend.track.domain.system.bo.ResultEntity;
import com.we.backend.track.service.business.DictionaryService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.we.backend.track.architect.constant.BussinessCode.GLOBAL_ERROR;

/**
 * Created by yukai on 2017-8-16.
 */
@Controller
@RequestMapping("dictionary")
public class DictionaryController {
    private static Logger logger= LoggerFactory.getLogger(DictionaryController.class);
    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/dic_list.do")
    public String toDicList(Model model)
    {
        try {
            List<Dictionary> parentDics=dictionaryService.getDictionary(0);
            model.addAttribute("parentDics",parentDics);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return "/business/dic_list";
    }


    @RequestMapping("/parents.do")
    @ResponseBody
    public ResultEntity getParentDic()
    {
        ResultEntity resultEntity=ResultEntity.build();
        try {
            List<Dictionary> dictionaries=dictionaryService.getDictionary(0);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return resultEntity.withError(GLOBAL_ERROR);
        }
        return resultEntity;
    }
    @RequestMapping("/children.do")
    @ResponseBody
    public ResultEntity getChildDic(Integer pageNum,Integer pageSize,Integer pid)
    {
        ResultEntity resultEntity=ResultEntity.build();
        try {
            PageHelper.startPage(pageNum,pageSize,true);
            List<Dictionary> dictionaries=dictionaryService.getDictionary(pid);
            PageInfo page = new PageInfo(dictionaries);
            System.out.println("------"+ JSON.toJSON(page));
            resultEntity.setData(page);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return resultEntity.withError(GLOBAL_ERROR);
        }
        return resultEntity;
    }
    @ResponseBody
    @RequestMapping("/all.do")
    public ResultEntity getAllDic()
    {
        ResultEntity resultEntity=ResultEntity.build();
        try {
            List<Dictionary> dictionaries=dictionaryService.getDictionary(null);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return resultEntity.withError(GLOBAL_ERROR);
        }
        return resultEntity;
    }
}
