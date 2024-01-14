package com.atguigu.spring6.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.UrlResource;

@Slf4j
// 延时URLResource访问网路资源
public class UrlResourceDemo {
    public static void main(String[] args) {
        //http前缀
        loadUrlResource("http://www.baidu.com");
        //file前缀,文件必须位于根目录（项目所在根目录）
        loadUrlResource("file:atguigu.txt");
    }
    //访问前缀是http、file
    public static void loadUrlResource(String path){
        try {
            //创建Resource实现类UrlResource
            UrlResource urlResource = new UrlResource(path);
            //获取资源信息
            System.out.println(urlResource.getFilename());
            System.out.println(urlResource.getURI());
            System.out.println(urlResource.getDescription());
            System.out.println(urlResource.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
