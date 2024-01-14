package com.atguigu.spring6.iocxml.di;


public class Book {
    private String bname;
    private String author;
    //生成构造
    public Book(String bname, String author) {
        System.out.println("有参构造执行了");
        this.bname = bname;
        this.author = author;
    }
    public Book() {
    }
    //生成set方法
    public void setBname(String bname) {this.bname = bname;}
    public void setAuthor(String author) {this.author = author;}



    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }



    public static void main(String[] args) {
        // set方法注入
        Book book = new Book();
        book.setBname("java");
        book.setAuthor("尚硅谷");
        Book book1 = new Book("C++", "尚硅谷");
    }
}
