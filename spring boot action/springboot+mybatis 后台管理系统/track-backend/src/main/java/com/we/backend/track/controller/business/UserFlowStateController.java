package com.we.backend.track.controller.business;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.backend.track.architect.constant.BussinessCode;
import com.we.backend.track.architect.constant.DictionaryConstant;
import com.we.backend.track.architect.constant.HandleStatus;
import com.we.backend.track.domain.business.po.UserFlowState;
import com.we.backend.track.domain.business.po.WorkSheet;
import com.we.backend.track.domain.business.vo.UserFlowStateVo;
import com.we.backend.track.domain.business.vo.WorkSheetVo;
import com.we.backend.track.domain.system.bo.ResultEntity;
import com.we.backend.track.service.business.DictionaryService;
import com.we.backend.track.service.business.UserFlowStateService;
import com.we.backend.track.service.business.WorkSheetService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yukai on 2017-8-21.
 */
@Controller
@RequestMapping("userFlow/state")
public class UserFlowStateController {
    private static Logger logger= LoggerFactory.getLogger(DictionaryController.class);
    @Autowired
    private UserFlowStateService userFlowStateService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private WorkSheetService workSheetService;

    @RequestMapping("/toList.do")
    public String toList(Model model)
    {
        List list=dictionaryService.fetchTitles(1);
        model.addAttribute("flows",list);
        model.addAttribute("dicDataMap", DictionaryConstant.dicDataMap);
        return "business/user_flow_state_list";
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public ResultEntity list(Integer pageNum,Integer pageSize,Integer flowId)
    {
        ResultEntity resultEntity=ResultEntity.build();
        try {
            PageHelper.startPage(pageNum,pageSize,true);
            List list=userFlowStateService.getUserFlowStates(flowId,null);
            PageInfo pageInfo=new PageInfo(list);
            Map result=new HashMap();
            result.put("dic",DictionaryConstant.dicDataMap);
            result.put("pageInfo",pageInfo);
            resultEntity.setData(result);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            resultEntity.withError(BussinessCode.GLOBAL_ERROR);
        }
        return resultEntity;
    }

    @RequestMapping("/checkAndLock.do")
    @ResponseBody
    public ResultEntity checkAndLock(Integer userFlowStateId)
    {
        ResultEntity resultEntity=ResultEntity.build();
        try {
            if (!userFlowStateService.checkAndLock(userFlowStateId))
            {
                resultEntity.withError("该数据正被其他人员处理中，请选择其他数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.withError("系统繁忙，请稍后再试或尝试处理其他数据");
        }
        return resultEntity;
    }

    @RequestMapping("/toEdit.do")
    public String toEdit(Integer userFlowStateId,Model model)
    {

        try {
            //1-添加工作记录
            userFlowStateService.toEdit(userFlowStateId);
            //2-查userFlowState
            UserFlowStateVo userFlowStateVo=userFlowStateService.get(userFlowStateId);
            model.addAttribute("userFlow",userFlowStateVo);
            //3-根据userFlowId 查workSheet
            WorkSheetVo workSheetVo=workSheetService.getByStateId(userFlowStateId);
            model.addAttribute("workSheet",workSheetVo);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }

        return "business/user_flow_state_edit";
    }

    @RequestMapping("/doEdit.do")
    @ResponseBody
    public ResultEntity doEdit(WorkSheet workSheet,UserFlowState userFlowState)
    {
        ResultEntity resultEntity=ResultEntity.build();
        //更新userFlowState状态 更新workSheet状态
        try {
            userFlowStateService.doEdit(workSheet, userFlowState);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            resultEntity.withError(BussinessCode.GLOBAL_ERROR);
        }
        return resultEntity;
    }


}
