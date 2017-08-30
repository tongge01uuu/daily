package com.we.p2p.timer.runner;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.core.logger.Logger;
import com.github.ltsopensource.core.logger.LoggerFactory;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.logger.BizLogger;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;
import com.github.ltsopensource.tasktracker.runner.LtsLoggerFactory;
import com.we.p2p.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service("demoJobRunner")
public class DemoJobRunner implements JobRunner {

    private static final Logger logger = LoggerFactory.getLogger(DemoJobRunner.class);

    @Autowired
    private DemoService demoService;

    @Override
    public Result run(JobContext jobContext) throws Throwable {
        try {
            logger.info("--------DemoJobRunner  start---------");
            demoService.demo();
            BizLogger bizLogger = LtsLoggerFactory.getBizLogger();
            bizLogger.info("SUCCESS");
        } catch (Exception e) {
            logger.info("Run job failed!", e);
            return new Result(Action.EXECUTE_LATER, e.getMessage());
        }
        return new Result(Action.EXECUTE_SUCCESS);
    }
}
