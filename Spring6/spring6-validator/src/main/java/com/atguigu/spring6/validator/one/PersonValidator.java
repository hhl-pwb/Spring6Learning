package com.atguigu.spring6.validator.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    /**
     * support方法用来表示此效验用在那个类型上
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }
    /**
     * validate方法是设置效验逻辑的地点，其中ValidationUtils，是Spring封装的效验工具类，帮助快速实现效验
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        //name不能为空
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty",
                "name is null");
        //age不能小于0，不能大于200
        Person p = (Person) target;
        if(p.getAge()<0){
            errors.rejectValue("age", "age.value.error", "age < 0");
        }else if(p.getAge()>200){
            errors.rejectValue("age", "age.value.error.old", "age > 200");
        }
    }
}
