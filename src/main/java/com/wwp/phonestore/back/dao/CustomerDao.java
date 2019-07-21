package com.wwp.phonestore.back.dao;

import com.wwp.phonestore.pojo.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository("customerDao")
public interface CustomerDao {
    //根据条件查询所有客户
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select1")
    public List<Customer> getCustomerList(Map<String,Object> map);

    //根据条件查询客户记录条数
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select2")
    public int getCustomerCount(String queryname);

    //添加一条客户信息
    @InsertProvider(type=PhoneMasterSqlProvider.class,method = "insert1")
     public int addCustomer(Customer customer);

    //通过id或者账号查找客户
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select3")
    public Customer getCustomer(Integer cid,String account);

    //更改用户信息
    @UpdateProvider(type=PhoneMasterSqlProvider.class,method = "update1")
    public int updateCustomer(Customer customer);

    //通过id删除该客户
    @Delete("delete from customer where id=#{cid}")
    public int  delCustomer(Integer cid);
}
