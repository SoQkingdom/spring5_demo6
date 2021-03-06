package com.atguigu.spring5.service;


import com.atguigu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {

    //注入Dao
    @Autowired
    private UserDao userDao;

    //转账的方法
    public void accountMoney(){
//        try{
            //第一步 开启事务

            //第二步 进行业务操作
            //Lucy少100
            userDao.reduceMoney();

            int i = 10/0;

            //Mary多100
            userDao.addMoney();
            //第三步 没有发生异常，提交事务

//        }catch (Exception e){
            //第四步 出现异常，事务回滚
//        }

    }
}
