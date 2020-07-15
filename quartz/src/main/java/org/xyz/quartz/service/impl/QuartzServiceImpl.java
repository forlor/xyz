package org.xyz.quartz.service.impl;

import com.bjhy.smm.maintenance.core.quartz.common.JobDispatcher;
import com.bjhy.smm.maintenance.core.quartz.common.QuartzJob;
import com.bjhy.smm.maintenance.core.quartz.service.QuartzService;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @ClassName QuartzServiceImpl
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/13 11:02
 * @Version 1.0
 **/
@Service
@Transactional
public class QuartzServiceImpl implements QuartzService {
    @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;
    private static final String QUARTZ_GROUP = "quartz_group";
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void create(String bId, String cronExpression, QuartzJob quartzJob) {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(quartzJob.getClass());
        if (beanNamesForType.length == 0) {
            throw new RuntimeException("quartzJob must be spring bean");
        }
        JobDetail jobDetail = JobBuilder.newJob(JobDispatcher.class)
                .withIdentity(bId, QUARTZ_GROUP)
                .build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(bId, QUARTZ_GROUP)
                .usingJobData(bId, beanNamesForType[0])
                .withSchedule(cronScheduleBuilder.withMisfireHandlingInstructionDoNothing())
                .build();
        try {
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public void delete(String bId) {
        try {
            scheduler.deleteJob(JobKey.jobKey(bId));
        } catch (SchedulerException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void update(String bId, String cronExpression, QuartzJob quartzJob) {
        String beanNameForType = null;
        if (quartzJob != null) {
            String[] beanNamesForType = applicationContext.getBeanNamesForType(quartzJob.getClass());
            if (beanNamesForType.length == 0) {
                throw new RuntimeException("quartzJob must be spring bean");
            }
            beanNameForType = beanNamesForType[0];
        }
        Optional<String> beanNamesOptional = Optional.ofNullable(beanNameForType);
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        try {
            Trigger trigger = scheduler.getTrigger(TriggerKey.triggerKey(bId));
            if (trigger != null) {
                TriggerKey triggerKey = trigger.getKey();
                CronTrigger updateTrigger = TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey.getName(), triggerKey.getGroup())
                        .usingJobData(bId, beanNamesOptional.orElse((String) trigger.getJobDataMap().get(bId)))
                        .withSchedule(cronScheduleBuilder.withMisfireHandlingInstructionDoNothing())
                        .build();
                scheduler.rescheduleJob(TriggerKey.triggerKey(bId), updateTrigger);
            }
        } catch (SchedulerException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void pauseAll() {
        try {
            scheduler.pauseAll();
        } catch (SchedulerException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void pause(String bId) {
        try {
            scheduler.pauseJob(JobKey.jobKey(bId));
        } catch (SchedulerException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void resumeAll() {
        try {
            scheduler.resumeAll();
        } catch (SchedulerException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void resume(String bId) {
        try {
            scheduler.resumeJob(JobKey.jobKey(bId));
        } catch (SchedulerException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
