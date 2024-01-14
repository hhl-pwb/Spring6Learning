package com.atguigu.spring6.autowired.service;

import com.atguigu.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UsreService{
    //注入dao
    //第一种方式 属性注入
//    @Autowired //根据类型找到对应对象，完成注入
//    private UserDao userDao;

//     第二种注入方式，set注入

//    private UserDao userDao;
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
    //第三中方式，构造注入
//    private UserDao userDao;
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
    //第四种方式，形参注入
    //第五种，注入注入
    @Autowired
    private UserDao userDao;
//
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void add() {
        System.out.println("srvice.......");
        userDao.add();
    }
}
