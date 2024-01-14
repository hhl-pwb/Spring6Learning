package com.atguigu.spring6.aop.example;

import com.atguigu.spring6.aop.anoaop.Calculator;

public class CalculatorStaticProxy implements Calculator {
    //被代理目标对象传递过来
    private Calculator calculator;
    //通过构造函数
    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        int addResult = calculator.add(1, 2);
        System.out.println("[日志] add 方法结束了，结果是：" + addResult);
        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
