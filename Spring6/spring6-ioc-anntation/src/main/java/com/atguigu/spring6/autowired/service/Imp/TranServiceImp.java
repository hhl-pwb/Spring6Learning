package com.atguigu.spring6.autowired.service.Imp;

import com.atguigu.spring6.autowired.dao.UserDao;
import com.atguigu.spring6.autowired.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranServiceImp implements TranService {
    @Autowired
    private UserDao userDao;
    @Override
    public void function(String str1, String str2,String str3) {
        System.out.println(str1+str2+str3);
        userDao.add();
        System.out.println("11111111111111111");
    }
}
