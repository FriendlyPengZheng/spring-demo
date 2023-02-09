package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.annotation.ControllerLog;
import com.example.springsecurityjwt.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
@CrossOrigin
//应用于spring bean的管理，决定实例是否是单例
@Scope("prototype")
public class HelloController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    @ControllerLog(name = "hello 测试")
    public String hello() {
        return "hello word";
    }

    @ControllerLog(name = "hello 测试")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        System.out.println("service: " + transactionService);
        System.out.println("this: " + this);
        System.out.println("test");
        return "test";
    }

    //    @ControllerLog(name = "hello 测试2")
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    public String test2() {
        return test();
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    @ResponseBody
    public String transaction() {
        try {
            transactionService.add();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hello word";
    }
}
