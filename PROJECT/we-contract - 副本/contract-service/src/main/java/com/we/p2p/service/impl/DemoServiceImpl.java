package com.we.p2p.service.impl;

import com.site.bean.resultBean.Result;
import com.we.p2p.logic.DemoLogic;
import com.we.p2p.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service("demoServiceImpl")
public class DemoServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private DemoLogic demoLogic;

    @Override
    public Result<String> demo() {
        Result<String> result = Result.build();
        result.success("123");
    /*
        参考一下：这是一个查询列表的服务

      List<BankSupportVo> voList = new ArrayList<>();
        try {
            List<BankSupport> bankList = bankSupportLogic.getBankList();
            if (null != bankList && bankList.size() != 0) {
                BankSupportVo bankVo = null;
                for (BankSupport bank : bankList) {
                    bankVo = VoConvertUtil.convertBank(bank);
                    voList.add(bankVo);
                }
            }
            result.success(voList);
        } catch (Exception e) {
            logger.error("BankSupportService getBankList error:", e);
            result.withError(ResultStatus.SYSTEM_ERROR.getCode(), ResultStatus.SYSTEM_ERROR.getMessage());
        }*/

        return result;
    }
}
