package com.atguigu.spring6.iocxml.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrders {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        Orders orders2 = context.getBean("orders",Orders.class);
        System.out.println(orders2);

        Orders orders21 = context.getBean("orders2", Orders.class);
        System.out.println(orders21);
        Orders orders22 = context.getBean("orders2",Orders.class);
        System.out.println(orders22);

    }
}
