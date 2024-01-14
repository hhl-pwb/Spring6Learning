package com.atguigu.spring6.xmltx.controller;

import com.atguigu.spring6.xmltx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    /**
     * 买书的方法:图书id和用户id
     *
     * @param bookId
     * @param userId
     */
    public void buyBook(Integer bookId, Integer userId) {
        bookService.buyBook(bookId, userId);
    }

//    @Autowired
//    private CheckoutService checkoutService;
//
//    public void checkBook(Integer[] bookIds,Integer userId){
//        checkoutService.checkout(bookIds,userId);
//    }

}
