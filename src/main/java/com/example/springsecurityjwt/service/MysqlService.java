package com.example.springsecurityjwt.service;

import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class MysqlService {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://10.155.6.22:3306/mydb";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public void add() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            int count = 0;
            for (int i = 0; i < 10; i++) {
                count++;
                String sql;
                sql = "INSERT INTO `mydb`.`dbz_test`( `task_name`, `file_name`, `file_position`, `start_time`,`id2`) VALUES ( ?,?, ?,? , ?);";
                stmt = conn.prepareStatement(sql);
                stmt.setObject(1, "taskName01888");
                stmt.setObject(2, "fileName01");
                stmt.setObject(3, System.currentTimeMillis());
                stmt.setObject(4, new Date(System.currentTimeMillis()));
                stmt.setObject(5, "pk1" + i);
                stmt.executeUpdate();
                Thread.sleep(1);
                if (count == 100) throw new Exception("手动异常抛出");
            }
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
