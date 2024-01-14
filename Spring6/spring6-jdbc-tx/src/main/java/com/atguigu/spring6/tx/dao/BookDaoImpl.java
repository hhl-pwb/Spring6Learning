package com.atguigu.spring6.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 根据图书id查询图书价格
     *
     * @param bookId
     * @return
     */
    @Override
    public Integer getBookPriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;
    }
    /**
     * 更新图书表库存量 -1
     *
     * @param bookId
     */
    @Override
    public void updateStock(Integer bookId) {
        String sql = "update t_book set stock = stock-1 where book_id = ? ";
        jdbcTemplate.update(sql,bookId);
    }
    /**
     * 更新用户表余额   -图书价格
     *
     * @param userId
     * @param price
     */
    @Override
    public void updateUserBalance(Integer userId, Integer price) {
        String sql = "update t_user set balance = balance- ? where user_id =?";
        jdbcTemplate.update(sql,price,userId);
    }
}
