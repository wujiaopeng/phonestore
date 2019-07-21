package com.wwp.phonestore.back.services;

import com.wwp.phonestore.back.dao.CustomerDao;
import com.wwp.phonestore.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getCustomerList(Map<String, Object> map) {
        return customerDao.getCustomerList(map);
    }

    @Override
    public int getCustomerCount(String queryname) {
        return customerDao.getCustomerCount(queryname);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        int num=customerDao.addCustomer(customer);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public Customer getCustomer(Integer cid, String account) {

        return customerDao.getCustomer(cid,account);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        int num=customerDao.updateCustomer(customer);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public boolean delCustomer(Integer cid) {
        int num=customerDao.delCustomer(cid);
        if(num>0)
            return true;
        return false;
    }
}
