package org.xyz.quartz.common;

import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @ClassName SchedulerConfig
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/10 15:06
 * @Version 1.0
 **/
@Configuration
public class SchedulerConfig {
    @Autowired
    private DataSource dataSource;
    @Autowired
    @Qualifier("autowireJobFactory")
    private JobFactory jobFactory;

    /**
     * @return
     * @throws IOException
     */
    @Bean(name = "schedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(jobFactory);
        factory.setDataSource(dataSource);
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factory.setOverwriteExistingJobs(true);
        //延长启动
        factory.setStartupDelay(1);
        factory.setConfigLocation(new ClassPathResource("/quartz.properties"));
        return factory;
    }

    /**
     * 通过SchedulerFactoryBean获取Scheduler的实例
     *
     * @return
     * @throws IOException
     */
    @Bean(name = "scheduler")
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }

//    @Bean
//    public QuartzInitializerListener executorListener() {
//        return new QuartzInitializerListener();
//    }


}
