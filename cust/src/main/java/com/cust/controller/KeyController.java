package com.cust.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.cust.dao.KeyDaoInterface;

import com.cust.model.Key;
import com.cust.service.KeyService;

@Controller
public class KeyController {
	@Autowired
	@Qualifier("keyService")
	private KeyDaoInterface keyService;

	
	

	public KeyDaoInterface getKeyService() {
		return keyService;
	}




	public void setKeyService(KeyDaoInterface keyService) {
		this.keyService = keyService;
	}




	@RequestMapping("/key")
	public String index(Model model,
			@RequestParam(value = "id", required = false,defaultValue="0") int id,
			@RequestParam(value = "activationKey", required = false) String activationKey,
			@RequestParam(value = "status", required = false) String status,
			//@RequestParam(value = "email", required = false) String email,			
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
			
				Key key = new Key(0,activationKey,status);			
				keyService.addKey(key);
				//model.addAttribute("customers", customerService.getallCustomers());
				model.addAttribute("message","Customer added :)");
			}else if(submit.equalsIgnoreCase("delete")){
				System.out.println("del");
				Key key1=keyService.getKey(id);	
				keyService.deleteKey(key1);
				if(null==keyService.getKey(id)) model.addAttribute("message","Key deleted :)");			
			}else if(submit.equalsIgnoreCase("update")){
				System.out.println("update");
				Key key2=keyService.getKey(id);
				key2.setActivationKey(activationKey);
				key2.setStatus(status);							
				keyService.updateKey(key2);
				model.addAttribute("message","Key updated :)");
				
			}else if(submit.equalsIgnoreCase("get")){
				System.out.println("get");
				Key c=keyService.getKey(id2get);
				model.addAttribute("key",c);
			}
		}
		
		return "keyslist"; 
	}
	
	
}
