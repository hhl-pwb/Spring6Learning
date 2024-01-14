package com.atguigu.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Target;

public class TestUser {
    // 创建logger对象
    private Logger logger = LoggerFactory.getLogger(TestUser.class);
    @Test
    public void testUserObject(){
        // 加载spring的配置文件，对象创建
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建对象
        User user = (User)context.getBean("user");
        System.out.println(user);
        // 使用对象调用方式进行测试
        user.add();
        //手动写日志
        logger.info("##执行调用成功了！");
    }
    @Test
    public void testUserObject1() throws Exception {
        //获取类Class对象
        Class clazz = Class.forName("com.atguigu.spring6.User");
        // 调用方法创建
//        Object o = clazz.newInstance();
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}
