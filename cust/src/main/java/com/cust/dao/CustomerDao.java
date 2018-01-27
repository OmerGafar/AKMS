package com.cust.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.cust.model.Customer;
@Service
@Configuration
@EnableTransactionManagement
@ImportResource({ "classpath:ApplicationContext.xml" })
public class CustomerDao implements CustomerDaoInerface{
	@Autowired
	HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	@Transactional
	public void addCustomer(Customer cust) {
		template.saveOrUpdate(cust);
		//template.flush();
	}

	@Override
	@Transactional
	public void updateCustomer(Customer cust) {
		template.update(cust);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer cust) {
		template.delete(cust);
		
	}

	@Override
	@Transactional
	public List<Customer> getallCustomers() {
		// TODO Auto-generated method stub
		return template.loadAll(Customer.class);
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		return template.get(Customer.class, id);
	}

}
