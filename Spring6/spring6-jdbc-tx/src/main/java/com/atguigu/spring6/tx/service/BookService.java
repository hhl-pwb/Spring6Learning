package com.atguigu.spring6.tx.service;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    /**
     * 买书的方法L图书id和用户id
     *
     * @param bookId
     * @param userId
     */
    public void buyBook(Integer bookId, Integer userId);
}
