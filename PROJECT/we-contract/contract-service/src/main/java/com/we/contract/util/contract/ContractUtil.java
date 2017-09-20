package com.we.contract.util.contract;

import com.we.contract.entity.FinancePlanContract;
import com.we.contract.enums.ContractType;
import com.we.contract.util.DateUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static com.we.contract.enums.ContractType.FINANCE_PLAN;

/**
 * Created by yukai on 2017-9-20.
 */
public class ContractUtil {
    private static Logger logger= LoggerFactory.getLogger(ContractUtil.class);
    public static String generateFilePath(Object contract,ContractType contractType)
    {
        StringBuffer path=new StringBuffer();
        try {
            switch (contractType){
                case FINANCE_PLAN:{
                    FinancePlanContract financePlanContract=(FinancePlanContract)contract;
                    Integer planId=financePlanContract.getFinancePlanId();
                    Integer userId=financePlanContract.getUserId();
                    //eg : finance_plan_contract/155076/finance_plan_155076_2458939_20170920171152.pdf
                    path.append(FINANCE_PLAN.getTable()).append("/")
                            .append(planId).append("/")
//                            .append(userId).append("/")
                            .append(financePlanContract.getSubPointType().toLowerCase()).append("_")
                            .append(planId).append("_").append(userId).append("_")
                            .append(DateUtil.format(new Date(),DateUtil.DATE_FORMAT_SECOND_SHORT)).append(".pdf");
                    break;
                }
                case LOAN_TRANSFER:{
                    break;

                }
                case BORROW:{
                    break;

                }
                default:{
                    break;
                }
            }
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return path.toString();
    }
}
