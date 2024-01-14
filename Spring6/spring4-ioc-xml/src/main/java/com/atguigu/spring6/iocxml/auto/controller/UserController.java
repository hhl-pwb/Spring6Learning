package com.atguigu.spring6.iocxml.auto.controller;
import com.atguigu.spring6.iocxml.auto.service.UserService;

public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller方法执行了...");
        // 原始调用
//        UserService userService = new UserServiceImpl();
//        userService.addUserServic();
        //使用注入调用Servic中的方法
        userService.addUserServic();
    }
}
