package com.wwp.phonestore.front.services;

import com.wwp.phonestore.pojo.Customer;

public interface UserService {

    //通过账号获取用户信息
    public Customer checkAccount(String account);

    //添加用户
    public boolean addUser(Customer customer);


}
