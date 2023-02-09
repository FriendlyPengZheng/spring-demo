package com.example.springsecurityjwt.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QuartzInitializer implements CommandLineRunner {

    @Autowired
    QuartzSchedulerManger quartzSchedulerManger;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("----------------------------调度启动-----------------------");
        quartzSchedulerManger.startJob();
    }

}
