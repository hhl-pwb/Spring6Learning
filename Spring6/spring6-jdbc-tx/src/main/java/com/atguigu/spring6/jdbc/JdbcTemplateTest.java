package com.atguigu.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //查询：返回对象
    @Test
    public void testSelectObject(){
        //写法一
        String sql = "select * from t_emp where id=?";
        Emp empResult = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Emp emp = new Emp();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setAge(rs.getInt("age"));
            emp.setSex(rs.getString("sex"));
            return emp;
        }, 1);
        System.out.println(empResult);
        //写法二
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(emp);
    }
    //查询：返回list集合
    @Test
    public void testSelectList(){
        String sql = "select * from t_emp";
        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(query);
    }
    //查询：返回单个值
    @Test
    public void testSelectValue(){
        String sql = "select count(*) from t_emp";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }


    // 添加 修改  删除操作
    @Test
    public void testUpdate(){

        //1 添加操作
        //第一步：编写sql语句
        String sql1 = "insert into t_emp values (null,?,?,?)";
        //第二步：调用jdbcTemplate的方法，传入相关参数
        int rows1 = jdbcTemplate.update(sql1, "林平直", 20, "未知");
        System.out.println(rows1);


        //修改操作
        String sql2 = "update t_emp set name=? where id=?";
        int rows2 = jdbcTemplate.update(sql2, "林平直atguigu", 3);
        System.out.println(rows2);

        //删除操作
        String sql3 = "delete from  t_emp where id=?";
        int rows3 = jdbcTemplate.update(sql3,  3);
        System.out.println(rows3);
    }
}
