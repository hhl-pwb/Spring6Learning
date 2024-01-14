package com.atguigu.spring6.autowired;


import com.atguigu.spring6.autowired.controller.UseerController;
import com.atguigu.spring6.autowired.util.ReflectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UseerController useerController = context.getBean(UseerController.class);
        useerController.add();
        ReflectionUtils.function();
    }
}
