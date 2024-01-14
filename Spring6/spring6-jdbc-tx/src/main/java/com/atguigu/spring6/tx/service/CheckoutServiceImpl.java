package com.atguigu.spring6.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private BookService bookService;

    /**
     * 买多本书的方法
     *
     * @param bookIds
     * @param userId
     */
    @Transactional
    @Override
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId : bookIds) {
            //调用BookService的方法
            bookService.buyBook(bookId, userId);
        }
    }
}
