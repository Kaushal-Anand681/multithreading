package com.kanand.multithreading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kanand.multithreading.entity.CustomerDTO;
import com.kanand.multithreading.service.CustomerSQLService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerSQLService customerSQLService;

	@PostMapping(value = "/saveCustomerData", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Object saveCustomerData(@RequestBody CustomerDTO customer) {
		String result = customerSQLService.saveCustomerData(customer);
		Gson gson= new GsonBuilder().create();
		return gson.toJson(result);
	}
	
	@DeleteMapping(value = "/deleteCustomerData/{id}")
	@ResponseBody
	public Object deleteCustomerData(@PathVariable Integer id) {
		String result =  customerSQLService.deleteCustomerData(id);
		Gson gson= new GsonBuilder().create();
		return gson.toJson(result);
	}

}
