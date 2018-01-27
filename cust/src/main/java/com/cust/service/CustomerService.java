package com.cust.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cust.dao.CustomerDaoInerface;
import com.cust.model.Customer;

@Service
public class CustomerService implements CustomerDaoInerface {
	@Autowired
	CustomerDaoInerface customerDao;
	public CustomerDaoInerface getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDaoInerface customerDao) {
		this.customerDao = customerDao;
	}

	@Override
    @Transactional
	public void addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		customerDao.addCustomer(cust);
	}

	@Override
    @Transactional
	public void updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(cust);
	}

	@Override
    @Transactional
	public void deleteCustomer(Customer cust) {
		
		customerDao.deleteCustomer(cust);
	}

	@Override
    @Transactional
	public List<Customer> getallCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getallCustomers();
	}

	@Override
    @Transactional
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(id);
	}

	/*@Override
	public boolean authinticateCustomer(Integer id, String pin) {
		// TODO Auto-generated method stub
		return customerDao.authinticateCustomer(id, pin);
	}*/

}
