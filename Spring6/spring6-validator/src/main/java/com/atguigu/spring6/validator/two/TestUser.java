package com.atguigu.spring6.validator.two;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {

    /**
     * 原生的Validator，返回是false表示效验不通过，返回true表示效验通过
     */
    @Test
    public void testValidatorOne(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation1 validation1 = context.getBean(MyValidation1.class);
        User user = new User();
        user.setAge(10);
        user.setName("Jack");
        boolean b = validation1.validatorByUserOne(user);
        System.out.println(b);
    }

    /**
     * Spring 校验器，返回true表示校验不通过，返回false表示校验通过
     */
    @Test
    public void testValidatorTwo(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation2 validation2 = context.getBean(MyValidation2.class);
        User user = new User();
        user.setAge(-1);
        user.setName("Jack");
        boolean b = validation2.validatorByUserTwo(user);
        System.out.println(b);
    }

}
