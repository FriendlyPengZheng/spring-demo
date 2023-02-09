package com.example.springsecurityjwt.quartz;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//@Configuration
//@Component
public class QuartzListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    QuartzSchedulerManger quartzSchedulerManger;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            quartzSchedulerManger.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
