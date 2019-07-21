package com.wwp.phonestore.front.services;

import com.wwp.phonestore.front.dao.UserDao;
import com.wwp.phonestore.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Customer checkAccount(String account) {
        return userDao.checkAccount(account);
    }

    @Override
    public boolean addUser(Customer customer) {
        int num=userDao.addUser(customer);
        if(num>0)
            return true;
        return false;
    }

}
