package com.cust.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cust.dao.CustomerDaoInerface;
import com.cust.dao.KeyDaoInterface;
import com.cust.model.Customer;
import com.cust.model.Key;
import com.cust.model.MailHelper;


@Service
public class ScheduledTasks {

	@Autowired
	@Qualifier("keyService")
	private KeyDaoInterface keyService;


	public KeyDaoInterface getKeyService() {
		return keyService;
	}




	public void setKeyService(KeyDaoInterface keyService) {
		this.keyService = keyService;
	}
	@Autowired
	@Qualifier("customerService")
	private CustomerDaoInerface customerService;


	




	public CustomerDaoInerface getCustomerService() {
		return customerService;
	}







	public void setCustomerService(CustomerDaoInerface customerService) {
		this.customerService = customerService;
	}


private static boolean running=false;

@Transactional
@Async
   public void sendkeys() {
	
if (running) return;
else running=true;
    	System.out.println(":::::  task is started :::::");
    	Key k=keyService.getLastKey();
    	if(null == k.getStatus() || k.getStatus().trim().equalsIgnoreCase("not sent"))
    	{
    		String activationKey=k.getActivationKey();
    		for(Customer cust :customerService.getallCustomers() )
    		{
    			if( null==cust.getLastKey() || (! cust.getLastKey().equals(activationKey)))
    			{
    				MailHelper.sendkey(cust, activationKey);
    				
    				cust.setLastKey(activationKey);
    				customerService.updateCustomer(cust);
    				System.out.println("sending last key sending :"+cust.getLastKey()+" to :"+cust.getEmail());
    			}
    			System.out.println("already have the last key ");
    		}
    		k.setStatus("Sent");
    		System.out.println("mail");
    		keyService.updateKey(k);
    	
    	}
    	running=false;
    	  }
	
    	
    }
