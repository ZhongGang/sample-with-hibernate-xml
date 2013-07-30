package com.icode.web.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-30
 * Time: 下午8:27
 */
@Controller
@RequestMapping("/shops")
public class ShopsBatchController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job shopsJob;

    @RequestMapping(value = "batch")
    public String shopsBatchExecution() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobExecution jobExecution = jobLauncher.run(shopsJob, new JobParameters());
        BatchStatus status = jobExecution.getStatus();
        return "redirect:/shop/overview";
    }
}
