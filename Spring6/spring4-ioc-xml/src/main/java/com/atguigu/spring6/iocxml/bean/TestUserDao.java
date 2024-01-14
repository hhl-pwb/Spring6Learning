package com.atguigu.spring6.iocxml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext contenxt = new ClassPathXmlApplicationContext("bean.xml");
        //根据接口类型获取接口对应的bean
        UserDao userDao = contenxt.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.run();
    }
}
