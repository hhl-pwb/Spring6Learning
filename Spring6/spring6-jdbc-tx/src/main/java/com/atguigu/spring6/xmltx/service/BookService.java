package com.atguigu.spring6.xmltx.service;

public interface BookService {
    /**
     * 买书的方法L图书id和用户id
     *
     * @param bookId
     * @param userId
     */
    public void buyBook(Integer bookId, Integer userId);
}
