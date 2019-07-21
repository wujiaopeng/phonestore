package com.wwp.phonestore.front.dao;

import com.wwp.phonestore.pojo.Customer;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("userDao")
public interface UserDao {

    //通过账号获取客户信息
    @Select("select * from customer where account=#{account}")
    public Customer checkAccount(String account);

    //添加用户
    @InsertProvider(type=SqlProvider.class,method = "insert2")
    public int addUser(Customer customer);


}
