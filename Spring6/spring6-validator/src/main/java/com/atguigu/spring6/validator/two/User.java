package com.atguigu.spring6.validator.two;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
    @NotNull
    private String name;
    @Min(0)
    @Max(150)
    private int age;
}
