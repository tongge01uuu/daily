package com.we.backend.track.service.business;

import com.we.backend.track.dao.business.WorkSheetMapper;
import com.we.backend.track.dao.system.UserMapper;
import com.we.backend.track.domain.business.po.WorkSheet;
import com.we.backend.track.domain.business.po.WorkSheetExample;
import com.we.backend.track.domain.business.vo.WorkSheetVo;
import com.we.backend.track.domain.system.vo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yukai on 2017-8-23.
 */
@Service
public class WorkSheetService {
    @Autowired
    private WorkSheetMapper workSheetMapper;
    @Autowired
    private UserMapper userMapper;

    public WorkSheet get(Integer workSheetId)throws Exception
    {
        WorkSheet workSheet = workSheetMapper.selectByPrimaryKey(workSheetId);
        return workSheet;
    }

    public WorkSheetVo getByStateId(Integer stateId)throws Exception
    {
        WorkSheetExample  workSheetExample=new WorkSheetExample();
        WorkSheetExample.Criteria criteria=workSheetExample.createCriteria();
        criteria.andStateIdEqualTo(stateId);
        List<WorkSheet> workSheets=workSheetMapper.selectByExample(workSheetExample);
        WorkSheet workSheet=null;
        WorkSheetVo workSheetVo=null;
        if (workSheets!=null && workSheets.size()>0)
        {
            workSheet=workSheets.get(0);
            User user=userMapper.selectByPrimaryKey(workSheet.getWorkerId());
            workSheetVo=new WorkSheetVo();
            BeanUtils.copyProperties(workSheet,workSheetVo);
            workSheetVo.setWorkerName(user.getUserName());
        }
        return workSheetVo;
    }

    public int update(WorkSheet workSheet)
    {
        return workSheetMapper.updateByPrimaryKeySelective(workSheet);
    }

    public boolean isExist(Integer stateId)throws Exception
    {
        boolean result=false;
        WorkSheet workSheet=getByStateId(stateId);
        if (workSheet!=null)
        {
            result=true;
        }
        return result;
    }
}
