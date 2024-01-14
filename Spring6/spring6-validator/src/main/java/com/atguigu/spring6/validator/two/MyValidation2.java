package com.atguigu.spring6.validator.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

@Service
public class MyValidation2 {

    @Autowired
    private Validator validator;

    public boolean validatorByUserTwo(User user){
        BindException bindException = new BindException(user,user.getName());
        validator.validate(user,bindException);
        System.out.println(bindException.getAllErrors());
        //有错误返回true，表示校验不通过，反之 返回true，检验通过
        return bindException.hasErrors();
    }
}
