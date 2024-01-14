package com.atguigu.spring6.xmltx.service;

import com.atguigu.spring6.xmltx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    /**
     * 买书的方法L图书id和用户id
     *
     * @param bookId
     * @param userId
     */
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //TODO 模拟超时
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        //更新图书表库存量 -1
        bookDao.updateStock(bookId);
        //更新用户表余额   -图书价格
        bookDao.updateUserBalance(userId, price);
//        System.out.println(1/0);
    }
}
