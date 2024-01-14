package com.atguigu.spring6.iocxml.auto.service;
import com.atguigu.spring6.iocxml.auto.dao.UserDao;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserServic() {
        System.out.println("UserService方法执行了...");
//        UserDao userDao = new UserDaoImpl();
//        userDao.addUserDao();
        //使用注入的方式调用
        userDao.addUserDao();
    }
}
