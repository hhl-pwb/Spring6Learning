package com.atguigu.reflect;
public class Car {
    private String name;
    private int age;
    private String color;
//    无参构造
    public Car() {
    }
    //有参构造
    public Car(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    private void run(){
        System.out.println("私有方法-run.....");
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
