package org.xyz.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ClassName MyJob
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/10 9:55
 * @Version 1.0
 **/
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务开始执行"+context.getJobInstance());
    }
}
