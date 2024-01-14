package com.atguigu.spring6.iocxml.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
    @Test
    public void textSetter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-bi.xml");
        //id和类型
        Book book = context.getBean("book",Book.class);
        System.out.println(book);
    }
    @Test
    public void textCon(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-bi.xml");
        Book book = context.getBean("bookCon",Book.class);
        System.out.println(book);
    }

}
