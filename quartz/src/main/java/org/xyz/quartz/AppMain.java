package org.xyz.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.xyz.quartz.config.CronDate;
import org.xyz.quartz.config.CronUtil;
import org.xyz.quartz.config.MyJobTest;
import org.xyz.quartz.config.QuartzJob;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AppMain
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/10 9:57
 * @Version 1.0
 **/
@SpringBootApplication
public class AppMain implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CronDate cronDate = new CronDate();
        //cronDate.setHour(16);
        //cronDate.setMinute(30);
        cronDate.setSeconds(10);
        String cron = CronUtil.cron(cronDate);
        JobDetail xyz = JobBuilder.newJob(MyJobTest.class)
                .withIdentity(JobKey.jobKey("xyz1"))
                .withIdentity("xyz1","xyz1")
                .build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger build = TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey("xyz1"))
                .withIdentity("xyz1","xyz1")
                .withSchedule(cronScheduleBuilder).build();

        scheduler.scheduleJob(xyz, build);

        scheduler.start();
    }


}
