package com.cust.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cust.model.Customer;

public interface CustomerDaoInerface {
	public void addCustomer(Customer cust);
	public void updateCustomer(Customer cust);
	public void deleteCustomer(Customer cust);
	public List<Customer> getallCustomers();
	public Customer getCustomer(Integer id);
	//public boolean authinticateCustomer(Integer id,String pin);
}
