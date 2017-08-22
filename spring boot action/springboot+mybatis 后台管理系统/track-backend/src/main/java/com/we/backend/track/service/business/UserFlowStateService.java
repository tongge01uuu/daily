package com.we.backend.track.service.business;

import com.we.backend.track.architect.constant.DictionaryConstant;
import com.we.backend.track.architect.constant.FlowStatus;
import com.we.backend.track.dao.business.UserFlowStateMapper;
import com.we.backend.track.domain.business.po.Dictionary;
import com.we.backend.track.domain.business.po.UserFlowState;
import com.we.backend.track.domain.business.po.UserFlowStateExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by yukai on 2017-8-21.
 */
@Service
public class UserFlowStateService {

    @Autowired
    private UserFlowStateMapper userFlowStateMapper;

    public List<UserFlowState> getUserFlowStates(Integer flowId,Integer flowStatus)
    {
        flowStatus=flowStatus==null? FlowStatus.UN_FINISHED.getKey():flowStatus;
        UserFlowStateExample userFlowStateExample=new UserFlowStateExample();
        UserFlowStateExample.Criteria criteria=userFlowStateExample.createCriteria();
        criteria.andFlowStatusEqualTo(flowStatus);
        if (flowId!=null)
        {
            criteria.andFlowIdEqualTo(flowId);
        }
        List<UserFlowState> list=userFlowStateMapper.selectByExample(userFlowStateExample);
        return list;
    }


}
