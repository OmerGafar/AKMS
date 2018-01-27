package com.cust.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cust.dao.CustomerDaoInerface;
import com.cust.model.Account;
import com.cust.model.Customer;
import com.cust.model.MailHelper;
import com.cust.service.CustomerService;
import com.cust.service.ScheduledTasks;
//@EnableWebMvc
@Controller
public class CustomerController {
	@Autowired
	@Qualifier("customerService")
	private CustomerDaoInerface customerService;


	




	public CustomerDaoInerface getCustomerService() {
		return customerService;
	}







	public void setCustomerService(CustomerDaoInerface customerService) {
		this.customerService = customerService;
	}






	@RequestMapping("/customer")
	public String index(Model model,
			@RequestParam(value = "id", required = false,defaultValue="0") int id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "email", required = false) String email,
			//@RequestParam(value = "note", required = false) String note,
			@RequestParam(value = "submit", required = false) String submit,
			@RequestParam(value = "id2get", required = false) Integer id2get
			){
	
		System.out.println("ctrl ...:)");
	
		//int id=Integer.parseInt(null== id2?"0":id2);
		//int id2get2=Integer.parseInt(null==id2get?"0":id2get);
		//model.addAttribute("customers", customerService.getallCustomers());
		if(null!=submit)
		{
			System.out.println("not null block");
			if(submit.equalsIgnoreCase("insert")){
				System.out.println("inst");
			
				Customer cust = new Customer(0,name,email,phone);
			
				customerService.addCustomer(cust);
				//model.addAttribute("customers", customerService.getallCustomers());
				model.addAttribute("message","Customer added :)");
			}else if(submit.equalsIgnoreCase("delete")){
				System.out.println("del");
				Customer cust1=customerService.getCustomer(id);		
				getCustomerService().deleteCustomer(cust1);
				if(null==customerService.getCustomer(id))model.addAttribute("message","Customer deleted :)");			
			}else if(submit.equalsIgnoreCase("update")){
				System.out.println("update");
				Customer cust1=customerService.getCustomer(id);
				cust1.setName(name);
				//cust1.setAddress(address);
				customerService.updateCustomer(cust1);
				model.addAttribute("message","Customer updated :)");
			}else if(submit.equalsIgnoreCase("get")){
				System.out.println("get");
				Customer c=customerService.getCustomer(id2get);
				model.addAttribute("cust",c);
			}
		}
		
		return "customerslist"; 
	}
	
	/*@RequestMapping("/addcustomer")
	public String add(Model model,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "note", required = false) String note,
			@RequestParam(value = "submit", required = false) String submit
			){
		
		
		Customer cust = new Customer(0,name,address,password);

		customerService.addCustomer(cust);
		//model.addAttribute("customers", customerService.getallCustomers());
		model.addAttribute("message","Custmer added :)");
		//model.addAttribute("cust", customerService.getCustomer(id));
		return "customerslist"; 
	}*/
}
