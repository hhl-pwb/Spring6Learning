package com.atguigu.spring6.autowired;

import com.atguigu.spring6.autowired.controller.UseerController;
import com.atguigu.spring6.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserControllerAnno {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UseerController bean = context.getBean(UseerController.class);
        bean.add();

    }
}
