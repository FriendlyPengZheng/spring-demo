package com.example.springsecurityjwt.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QuartzInitializer implements CommandLineRunner {

    @Autowired
    QuartzSchedulerManger quartzSchedulerManger;

    @Override
    public void run(String... args) throws Exception {
        log.info("----------------------------调度启动-----------------------");
        quartzSchedulerManger.startJob();
    }

}
