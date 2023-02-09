package com.example.springsecurityjwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * 实现了Spring Security UserDetailsService接口。
 * 它会覆盖loadUserByUsername,以便使用用户名从数据库中获取用户详细信息。
 * 当对用户提供的用户详细信息进行身份验证时，Spring Security Authentication Manager调用此方法从数据库中获取用户详细信息。
 * 在这里，我们从硬编码的用户列表中获取用户详细信息。
 * 在接下来的教程中，我们将增加从数据库中获取用户详细信息的DAO实现。用户密码也使用BCrypt以加密格式存储。
 * 在这里，您可以使用在线Bcrypt生成器为密码生成Bcrypt。
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            /*
            {
                "username": "admin",
                "password": "password"
            }
            */
            return new User("admin", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
