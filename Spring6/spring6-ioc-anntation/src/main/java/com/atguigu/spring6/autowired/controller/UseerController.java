package com.atguigu.spring6.autowired.controller;

import com.atguigu.spring6.autowired.service.UsreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UseerController {
    //注入servic
    //第一种方式 属性注入
//    @Autowired //根据类型找到对应对象，完成注入
//    private UsreService usreService;
//    /**
//     * 第二种方式，set方式注入
//     */
//    private UsreService usreService;
//    @Autowired
//    public void setUsreService(UsreService usreService) {
//        this.usreService = usreService;
//    }
    //第三种构造方法注入
//    private UsreService usreService;
//    @Autowired
//    public UseerController(UsreService usreService) {
//        this.usreService = usreService;
//    }
    //第四种方式，形参注入
//    private UsreService usreService;
//
//    public UseerController(@Autowired UsreService usreService) {
//        this.usreService = usreService;
//    }
    //第五种方式，有且只有一个有参构造方法，无注解
    // 构造方法只有一个，并且是有参数构造
    private UsreService usreService;

    public UseerController(UsreService usreService) {
        this.usreService = usreService;
    }

    public void add(){
        System.out.println("controller....");
        usreService.add();
    }
}
