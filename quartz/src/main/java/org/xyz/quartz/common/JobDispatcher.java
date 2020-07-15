package org.xyz.quartz.common;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @ClassName MyJobTest
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/13 16:15
 * @Version 1.0
 **/

public class JobDispatcher implements Job {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void execute(JobExecutionContext context) {
        Trigger trigger = context.getTrigger();
        String bId = trigger.getKey().getName();
        JobDataMap jobDataMap = trigger.getJobDataMap();
        String beanName = (String) jobDataMap.get(bId);
        QuartzJob bean = applicationContext.getBean(beanName, QuartzJob.class);
        bean.execute(bId);
    }
}
