package com.we.contract.vo;

import com.we.contract.constant.ContractTemplateType;
import com.we.contract.entity.ContractTemplate;
import org.springframework.beans.BeanUtils;

/**
 * Created by yukai on 2017-9-5.
 */
public class ContractTemplateVo extends ContractTemplate {
    private String voType;
    public ContractTemplateVo()
    {
    }
    public ContractTemplateVo(ContractTemplate contractTemplate)
    {
        BeanUtils.copyProperties(contractTemplate,this);
        try {
            this.voType=contractTemplate.getType()==null?null:ContractTemplateType.valueOf(contractTemplate.getType()).toString();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            this.voType=contractTemplate.getType();
        }
    }

    public String getVoType() {
        return voType;
    }

    public void setVoType(String voType) {
        this.voType = voType;
    }
}
