package com.atguigu.spring6.resource;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

//通过ClassPathResource获取类路径下的资源
public class ClassPathResourceDemo {
    public static void loadClasspathResource(String path){
        //创建ClassPathResource对象
        ClassPathResource resource = new ClassPathResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        //获取文件资源
        try {
            InputStream inputStream = resource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b)!=-1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        loadClasspathResource("atguigu.txt");
    }
}
