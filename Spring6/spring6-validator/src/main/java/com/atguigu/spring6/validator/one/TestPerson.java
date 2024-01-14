package com.atguigu.spring6.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class TestPerson {
    public static void main(String[] args) {
        //创建person对象
        Person person = new Person();
        person.setName("lucy");
        person.setAge(-1);
        //创建person对应的databinder
        DataBinder binder = new DataBinder(person);
        //设置效验器
        binder.setValidator(new PersonValidator());
        //调用方法执行
        binder.validate();
        //输出效验结果
        BindingResult result = binder.getBindingResult();
        System.out.println(result.getAllErrors());
    }
}
