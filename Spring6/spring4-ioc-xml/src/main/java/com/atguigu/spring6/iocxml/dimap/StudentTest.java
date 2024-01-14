package com.atguigu.spring6.iocxml.dimap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diref.xml");
        Student student = context.getBean("student", Student.class);
        Student studentp = context.getBean("studentp", Student.class);
        student.run();
        studentp.run();
    }

}
