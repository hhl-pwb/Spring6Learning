package com.atguigu.spring6.tx.controller;

import com.atguigu.spring6.tx.service.BookService;
import com.atguigu.spring6.tx.service.CheckoutService;
import org.apache.logging.log4j.core.config.builder.api.AppenderRefComponentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.print.Book;
import java.util.List;

@Controller
public class BookController {
//    @Autowired
//    private BookService bookService;
    /**
     * 买书的方法:图书id和用户id
     *
     * @param bookId
     * @param userId
     */
//    public void buyBook(Integer bookId, Integer userId) {
//        bookService.buyBook(bookId, userId);
//    }

    @Autowired
    private CheckoutService checkoutService;

    public void checkBook(Integer[] bookIds,Integer userId){
        checkoutService.checkout(bookIds,userId);
    }

}
