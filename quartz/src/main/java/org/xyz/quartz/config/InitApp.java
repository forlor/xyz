package org.xyz.quartz.config;

import org.quartz.core.QuartzScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;


/**
 * @ClassName InitApp
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/13 16:31
 * @Version 1.0
 **/
@Configuration
public class InitApp implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }
}
