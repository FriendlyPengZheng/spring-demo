package com.example.springsecurityjwt.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;

//@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    int id;
    String name;
}
