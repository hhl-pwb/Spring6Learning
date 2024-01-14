package com.atguigu.spring6.validator.three;

import com.atguigu.spring6.validator.four.CannotBlank;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class User {
    @NotNull
    private String name;
    @Min(0)
    @Max(150)
    private Integer age;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误！")
    @NotBlank(message = "手机号码不能为空！")
    private String phone;
    @CannotBlank
    private String message;
}
