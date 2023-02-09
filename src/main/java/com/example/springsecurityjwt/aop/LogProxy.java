package com.example.springsecurityjwt.aop;


import com.example.springsecurityjwt.annotation.ControllerLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 增强类
 */

@Aspect
@Slf4j
@Component
public class LogProxy {

    @Pointcut("execution(public * com.example.springsecurityjwt.controller.*.*(..))")
    public void pointCut(){
    }

    @Before(value = "pointCut() && @annotation(controllerLog)")
    public void beforeLog(ControllerLog controllerLog){
      log.info("log before");
    }

    @Before(value = "pointCut()")
    public void beforeLog2(){
        log.info("log before2");
    }

//    @After(value = "pointCut()")
    @After(value = "@annotation(controllerLog)")
    public void afterLog(ControllerLog controllerLog){
        log.info("log after");
    }
}
