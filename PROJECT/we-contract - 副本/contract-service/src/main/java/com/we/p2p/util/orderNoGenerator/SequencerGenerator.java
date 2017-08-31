package com.we.p2p.util.orderNoGenerator;

import com.site.development.exception.LogicException;
import com.we.p2p.util.DateUtil;
import com.we.p2p.util.RedisKeyConstant;
import com.we.p2p.util.StringUtil;
import com.we.p2p.util.cache.RedisClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * @Description:单号生成器
 */
@Service
public class SequencerGenerator {

    private static final Logger logger = LoggerFactory.getLogger(SequencerGenerator.class);

    private final static String ZZ = "ZZ";// 转账

    private final static String DD = "DD";// 订单

    private final static String TR = "TR";// 交易记录

    private final static String RDN = "RDN";//第三方流水号refund_no

    private final static String PB = "PB";// 付款单流水号 pay_no

    @Resource
    private TransferNo transferNo;

    @Resource
    private OrderNo orderNo;

    @Resource
    private TradeRecordNo tradeRecordNo;

    @Resource
    private ThirdRecordNo thirdRecordNo;

    @Resource
    private RefundNo refundNo;

    @Resource
    private PaymentBillNo paymentBillNo;


    @Resource(name = "redisUtils")
    private RedisClientUtils redisUtils;

    /**
     * 转账流水号：时间17位+3位序列 23位
     */
    public String getTransferNo() {
        String number = null;
        try {
            number = ZZ + transferNo.getNo();
        } catch (Exception e) {
        }
        return number;
    }

    /**
     * 订单流水号：时间17位+3位序列 23位
     */
    public String getOrderNo() {
        String number = null;
        try {
            number = DD + orderNo.getNo();
        } catch (Exception e) {
        }
        return number;
    }

    /**
     * 退款流水号：时间17位+3位序列 23位
     */
    public String getRefundNo() {
        String number = null;
        try {
            number = RDN + refundNo.getNo();
        } catch (Exception e) {
        }
        return number;
    }

    /**
     * 交易流水号：时间17位+3位序列 23位
     */
    public String getTradeRecordNo() {
        String number = null;
        try {
            number = TR + tradeRecordNo.getNo();
        } catch (Exception e) {
        }
        return number;
    }

    /**
     * 三方记录流水号：时间17位+3位序列 23位
     */
    public String getThirdRecordNo() {
        String number = null;
        try {
            number =  thirdRecordNo.getNo();
        } catch (Exception e) {
        }
        return number;
    }

    public String getPaymentBillNo() {
        String number = null;
        try {
            number = PB + paymentBillNo.getNo();
        } catch (Exception e) {
        }
        return number;

    }

    /**
     * 文件批次号
     *
     * @return
     */
    public String getFileBatchNo() {
        String batchNo = "";
        try {
            String dateString = DateUtil.formatCompactDate(new Date());
            Long batchNum = redisUtils.hincrBy(RedisKeyConstant.FILE_BATCH_NO, dateString, 1);
            if (batchNum >= 1000) {
                throw new LogicException("batchNo overflow now is :" + batchNum);
            }
            batchNo = new DecimalFormat(StringUtil.getZeroString(3)).format(batchNum);
        } catch (Exception e) {
            logger.error("getFileBatchNo error:" + e.getMessage(),e);
            throw new LogicException(e.getMessage());
        }
        return batchNo;
    }


}
