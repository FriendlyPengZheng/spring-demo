package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.modle.User;
import org.apache.naming.factory.BeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.sound.midi.Soundbank;

@Service
public class InitDiService implements CommandLineRunner {

    public void init() throws ClassNotFoundException,IllegalAccessException,InstantiationException {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("static/bean.xml");
        User user = (User) classPathXmlApplicationContext.getBean("user");
        System.out.println(user.toString());

        Class<?> aClass = Class.forName("com.example.springsecurityjwt.modle.User");
        User user2 = (User) aClass.newInstance();
        System.out.println(user2.toString());
    }

    @Override
    public void run(String... args) throws Exception {
        init();
    }
}
