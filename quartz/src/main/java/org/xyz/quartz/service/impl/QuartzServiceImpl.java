package org.xyz.quartz.service.impl;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.xyz.quartz.config.MyJobTest;
import org.xyz.quartz.service.QuartzService;

/**
 * @ClassName QuartzServiceImpl
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/13 11:02
 * @Version 1.0
 **/
@Service
public class QuartzServiceImpl implements QuartzService {
    @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;
    private static final String QUARTZ_GROUP = "quartz_group";

    @Override
    public void create(String key, String cronExpression) throws SchedulerException {
        String name = key + "_name";
        JobDetail jobDetail = JobBuilder.newJob(MyJobTest.class)
                .withIdentity(JobKey.jobKey(key))
                .withIdentity(name, QUARTZ_GROUP)
                .build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey(key))
                .withIdentity(name, QUARTZ_GROUP)
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void update(String key, String cronExpression) {

    }

    @Override
    public void pauseAll() {

    }

    @Override
    public void pause(String key) {

    }

    @Override
    public void resumeAll() {

    }

    @Override
    public void resume(String key) {

    }
}
