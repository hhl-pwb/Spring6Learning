package com.atguigu.spring6.tx.service;

public interface CheckoutService {
    /**
     * 买多本书的方法
     * @param bookIds
     * @param userId
     */
    void checkout(Integer[] bookIds,Integer userId);
}
