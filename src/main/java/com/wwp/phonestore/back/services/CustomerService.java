package com.wwp.phonestore.back.services;

import com.wwp.phonestore.pojo.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    public List<Customer> getCustomerList(Map<String,Object> map);

    public int getCustomerCount(String queryname);

    public boolean addCustomer(Customer customer);

    public Customer getCustomer(Integer cid,String account);

    public boolean updateCustomer(Customer customer);

    public boolean delCustomer(Integer cid);
}
