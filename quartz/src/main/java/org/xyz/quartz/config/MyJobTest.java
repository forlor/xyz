package org.xyz.quartz.config;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;

/**
 * @ClassName MyJobTest
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/13 16:15
 * @Version 1.0
 **/
public class MyJobTest implements QuartzJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Job jobInstance = context.getJobInstance();
        System.out.println("xyz");
    }
}
