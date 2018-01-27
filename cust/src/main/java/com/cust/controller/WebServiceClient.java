package com.cust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cust.model.RequestMessage;
import com.cust.model.ResponseMessage;

@Controller
public class WebServiceClient {
	@RequestMapping(value="/webserviceclient",method = RequestMethod.GET)
	public String index(Model model){
		
		return "webserviceclient";
	}
	@RequestMapping(value="/webserviceclient",method = RequestMethod.POST)
	public String transfer(Model model,RequestMessage reqst
			/*@RequestParam(value = "act2", required = true) Integer act2,
			@RequestParam(value = "act1", required = true) Integer act1,
			@RequestParam(value = "pin", required = true) String pin,
			@RequestParam(value = "submit", required = true) String submit,
			@RequestParam(value = "val", required = true) Integer val*/
			){
		System.out.println("act1::"+reqst.getAct1());
		RestTemplate webServClient=new RestTemplate();
		ResponseMessage result=webServClient.postForObject("http://localhost:8080/cust/transfer", reqst,ResponseMessage.class );
		model.addAttribute("response",result);
		return "webserviceclient";
	}
}
