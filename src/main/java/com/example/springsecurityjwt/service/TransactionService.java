package com.example.springsecurityjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLException;

@Service
@Scope("prototype")
public class TransactionService {

    @Autowired
    private MysqlService mysqlService;

//    @Transactional
    public void add() {
        try {
//            mysqlService.add();
            add2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void add2() {
        try {
            mysqlService.add();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Transactional
    public void add3() {
        try {
            mysqlService.add();
            deal3();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Transactional(rollbackFor = SQLException.class)
    public void deal3() {
        if (true) {
            //SQL异常 事务
//   udao.insert();
        }
    }

}
