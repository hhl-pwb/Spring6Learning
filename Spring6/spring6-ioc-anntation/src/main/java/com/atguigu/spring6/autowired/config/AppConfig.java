package com.atguigu.spring6.autowired.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// AppConfig.java
@Configuration
@ComponentScan(basePackages = "com.atguigu.spring6.autowired")
public class AppConfig {
    // 如果有其他配置可在这里添加
}

