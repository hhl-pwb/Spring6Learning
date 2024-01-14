package com.atguigu.spring6.xmltx.dao;

public interface BookDao {
    /**
     * 根据图书id查询图书价格
     *
     * @param bookId
     * @return
     */
    Integer getBookPriceByBookId(Integer bookId);

    /**
     * 更新图书表库存量 -1
     *
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户表余额   -图书价格
     *
     * @param userId
     * @param price
     */
    void updateUserBalance(Integer userId, Integer price);
}
