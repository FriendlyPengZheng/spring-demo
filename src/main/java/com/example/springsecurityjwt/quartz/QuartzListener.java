package com.example.springsecurityjwt.quartz;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//@Configuration
//@Component

/**
 * 一些比较独立、内容小巧的初始化逻辑，不影响springboot启动速度的使用@PostConstruct注解；
 * 若想通过ApplicationListener事件监听的方式，则需要处理好指定的容器。
 * 在数据初始化层面，不推荐@PostConstruct和ApplicationListener，原因是两者都会影响程序的启动。如果执行逻辑耗时很长，会启动服务就很长。
 * 建议使用 CommandLineRunner、ApplicationRunner的方式，不会影响服务的启动速度 ，处理起来也比较简单。
 */
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
