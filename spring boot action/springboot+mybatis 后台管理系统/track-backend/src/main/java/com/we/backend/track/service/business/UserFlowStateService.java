package com.we.backend.track.service.business;

import com.we.backend.track.architect.constant.DictionaryConstant;
import com.we.backend.track.architect.constant.FlowStatus;
import com.we.backend.track.architect.constant.HandleStatus;
import com.we.backend.track.architect.constant.WorkerConstant;
import com.we.backend.track.dao.business.DictionaryMapper;
import com.we.backend.track.dao.business.UserFlowStateMapper;
import com.we.backend.track.dao.business.WorkSheetMapper;
import com.we.backend.track.domain.business.po.Dictionary;
import com.we.backend.track.domain.business.po.UserFlowState;
import com.we.backend.track.domain.business.po.UserFlowStateExample;
import com.we.backend.track.domain.business.po.WorkSheet;
import com.we.backend.track.domain.business.vo.UserFlowStateVo;
import com.we.backend.track.domain.business.vo.WorkSheetVo;
import com.we.backend.track.domain.system.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yukai on 2017-8-21.
 */
@Service
public class UserFlowStateService {

    @Autowired
    private UserFlowStateMapper userFlowStateMapper;
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Autowired
    private WorkSheetMapper workSheetMapper;
    @Autowired
    private WorkSheetService workSheetService;

    public List<UserFlowStateVo> getUserFlowStates(Integer flowId,Integer flowStatus)throws Exception
    {
        flowStatus=flowStatus==null? FlowStatus.UN_FINISHED.getKey():flowStatus;
        UserFlowStateExample userFlowStateExample=new UserFlowStateExample();
        UserFlowStateExample.Criteria criteria=userFlowStateExample.createCriteria();
        criteria.andFlowStatusEqualTo(flowStatus);
        userFlowStateExample.setOrderByClause("handle_state asc");
        if (flowId!=null)
        {
            criteria.andFlowIdEqualTo(flowId);
        }
        List<UserFlowState> list=userFlowStateMapper.selectByExample(userFlowStateExample);
        List<UserFlowStateVo> voList=new ArrayList<>();
        UserFlowStateVo userFlowStateVo=null;
        WorkSheetVo workSheetVo=null;
        for (UserFlowState userFlowState :list)
        {
            userFlowStateVo=new UserFlowStateVo();
            BeanUtils.copyProperties(userFlowState,userFlowStateVo);
            if (userFlowState.getHandleState()!=HandleStatus.UN_HANDLE.getKey())
            {
                workSheetVo=workSheetService.getByStateId(userFlowState.getId());
                if (workSheetVo!=null)
                {
                    userFlowStateVo.setWorkerName(WorkerConstant.USER_MAP.get(workSheetVo.getWorkerId()).getUserName());
                }
            }
            voList.add(userFlowStateVo);
        }
        return voList;
    }

    public UserFlowStateVo get(Integer id)throws Exception
    {
        UserFlowState userFlowState=userFlowStateMapper.selectByPrimaryKey(id);
        UserFlowStateVo userFlowStateVo=new UserFlowStateVo();
        BeanUtils.copyProperties(userFlowState,userFlowStateVo);
        Dictionary dictionary=dictionaryMapper.selectByPrimaryKey(userFlowState.getFlowId());
        userFlowStateVo.setFlowName(dictionary.getName());
        return userFlowStateVo;
    }
    public boolean checkAndLock(Integer id)throws Exception
    {
        boolean result=true;
        UserFlowState userFlowState=get(id);
        Subject currentUser = SecurityUtils.getSubject();
        User user = currentUser.getPrincipals().oneByType(User.class);
        WorkSheet workSheet=workSheetService.getByStateId(id);
        synchronized (UserFlowStateService.class)
        {
            if (userFlowState.getHandleState()!=HandleStatus.UN_HANDLE.getKey()&&workSheet.getWorkerId()!=user.getUserId())
            {
                result=false;
            }else {
                if (userFlowState.getHandleState()==HandleStatus.UN_HANDLE.getKey())
                {
                    updateHandleState(id,HandleStatus.HANDLING);
                }
            }
        }

        return result;
    }

    public void updateHandleState(Integer userFlowStateId, HandleStatus handleStatus)throws Exception
    {
        UserFlowState userFlowState=new UserFlowState();
        userFlowState.setId(userFlowStateId);
        userFlowState.setHandleState(handleStatus.getKey());
        userFlowStateMapper.updateByPrimaryKeySelective(userFlowState);
    }


    @Transactional
    public void toEdit(Integer userFlowStateId)throws Exception
    {
//        updateHandleState(userFlowStateId, HandleStatus.HANDLING);

        WorkSheet workSheet=new WorkSheet();
        workSheet.setStateId(userFlowStateId);
        Subject currentUser = SecurityUtils.getSubject();
        User user = currentUser.getPrincipals().oneByType(User.class);
        workSheet.setWorkerId(user.getUserId());

        if (workSheetService.isExist(userFlowStateId))
        {
            workSheetMapper.updateByPrimaryKeySelective(workSheet);
        }else {
            workSheetMapper.insert(workSheet);
        }
    }

    @Transactional
    public void doEdit(WorkSheet workSheet,UserFlowState userFlowState)throws Exception {
        userFlowState.setId(workSheet.getStateId());
        workSheetMapper.updateByPrimaryKeySelective(workSheet);
        userFlowStateMapper.updateByPrimaryKeySelective(userFlowState);
    }

}
