package org.xyz.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.xyz.quartz.job.MyJob;

import java.util.Date;

/**
 * @ClassName AppMain
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/10 9:57
 * @Version 1.0
 **/
public class AppMain {
    public static void main(String[] args) throws SchedulerException {
        JobDetail build = JobBuilder.newJob(MyJob.class).withIdentity("xyzJob", "xyz").build();
        SimpleTrigger build1 = TriggerBuilder.newTrigger().startNow().withIdentity("xyzTrigger", "xyz").withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(10, 5))
                .build();
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.scheduleJob(build, build1);
        defaultScheduler.start();
    }

}
