package com.we.contract.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.we.contract.constant.ContractTemplateType;
import com.we.contract.dao.ContractTemplateMapper;
import com.we.contract.entity.ContractTemplate;
import com.we.contract.entity.ContractTemplateExample;
import com.we.contract.vo.ContractTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yukai on 2017-9-4.
 */
@Service
public class ContractTemplateService {
    @Autowired
    private ContractTemplateMapper contractTemplateMapper;

    public List<ContractTemplate> list(ContractTemplateType contractTemplateType)throws Exception
    {
        ContractTemplateExample example=new ContractTemplateExample();
        example.setOrderByClause("enabled desc,updateTime desc");
        ContractTemplateExample.Criteria criteria=example.createCriteria();
        if (contractTemplateType!=null)
        {
            criteria.andTypeEqualTo(contractTemplateType.name());
        }
        List<ContractTemplate> list=contractTemplateMapper.selectByExample(example);
        return list;
    }

    public Integer batchUpdateStatus(Integer[] ids,Boolean enabled)throws Exception
    {
        return contractTemplateMapper.batchUpdateStatus(ids,enabled);
    }

    public ContractTemplate get(Integer id)throws Exception
    {
        ContractTemplate contractTemplate=contractTemplateMapper.selectByPrimaryKey(id);
        contractTemplate.setContent(contractTemplate.getContent().replace("<s:","&lt;s:").replace("</s:","&lt;/s:"));
        return contractTemplate;
    }

    public void save(ContractTemplate contractTemplate)throws Exception
    {
        contractTemplate.setCreatetime(new Date());
        contractTemplate.setUpdatetime(new Date());
        contractTemplateMapper.insert(contractTemplate);
    }

    public Integer update(ContractTemplate contractTemplate)throws Exception
    {
        contractTemplate.setUpdatetime(new Date());
        return contractTemplateMapper.updateByPrimaryKeySelective(contractTemplate);
    }
}
