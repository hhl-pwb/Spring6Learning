package com.atguigu.spring6.aop.example;

import com.atguigu.spring6.aop.anoaop.CalculationImpl;
import com.atguigu.spring6.aop.anoaop.Calculator;

public class TestCal {
    public static void main(String[] args) {
        //创建代理类对象(动态)
        ProxyFactory proxyFactory = new ProxyFactory(new CalculationImpl());
        Calculator calculator = (Calculator) proxyFactory.getPorxy();
        calculator.add(1,2);
        calculator.div(5,2);
    }
}
