package com.atguigu.spring6.aop.xmlaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(1,2);
//        calculator.div(1,0);
    }
}
