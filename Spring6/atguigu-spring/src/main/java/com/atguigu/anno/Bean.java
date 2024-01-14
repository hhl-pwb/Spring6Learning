package com.atguigu.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //用在类或者接口上
@Retention(RetentionPolicy.RUNTIME) //运行时生效
public @interface Bean {
}
