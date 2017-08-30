package com.we.demo.util;

import com.we.demo.BaseTest;
import com.we.p2p.util.orderNoGenerator.SequencerGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qibaichao on 2016/9/21.
 */
public class SequencerGeneratorTest extends BaseTest {

    @Autowired
    private SequencerGenerator sequencerGenerator;

    @Test
    public void fileBatchNo() {
        try {

            String batchNo = sequencerGenerator.getFileBatchNo();
            System.out.println(batchNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
