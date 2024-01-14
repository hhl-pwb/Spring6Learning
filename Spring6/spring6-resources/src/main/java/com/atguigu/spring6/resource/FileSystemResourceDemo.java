package com.atguigu.spring6.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

//访问系统资源
public class FileSystemResourceDemo {
    public static void main(String[] args) {
        // 相对路径，读取的是项目根目录的文件
        loadFileSystemResource("atguigu.txt");
        //绝对路径，读取的是文件系统路径下的文件
        loadFileSystemResource("g:\\atguigu.txt");
    }
    public static void loadFileSystemResource(String path) {
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        System.out.println(fileSystemResource.getFilename());
        System.out.println(fileSystemResource.getDescription());
        try {
            InputStream inputStream = fileSystemResource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
