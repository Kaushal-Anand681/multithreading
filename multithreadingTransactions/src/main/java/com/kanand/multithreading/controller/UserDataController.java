package com.kanand.multithreading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kanand.multithreading.dto.User;
import com.kanand.multithreading.model.Customer;
import com.kanand.multithreading.service.CustomerDataService;
import com.kanand.multithreading.service.ReadXMLFileService;
import com.kanand.multithreading.service.UserDataService;

@RestController
@RequestMapping("/user")
public class UserDataController {

	@Autowired
	private UserDataService userDataService;

	@Autowired
	private CustomerDataService customerDataService;
	
	@Autowired
	private ReadXMLFileService xmlDataService;

	/*
	 * @PostMapping(value = "/saveUserData", consumes = "application/json", produces
	 * = "application/json")
	 * 
	 * @ResponseBody public String saveUserData(UserData user) { return
	 * userDataService.saveUserData(user); }
	 */
//	checksyncStatus

	@GetMapping(value = "/readDataFromProperties", produces = "application/json")
	@ResponseBody
	public String readDataFromProperties() {
		return userDataService.readDataFromProperties();
	}

	@GetMapping(value = "/readDataFromCSV", produces = "application/json")
	@ResponseBody
	public List<Customer> readDataFromCSV() {
		return userDataService.readDataFromCSV();
	}

	@GetMapping(value = "/readDataFromJson", produces = "application/json")
	@ResponseBody
	public List<Customer> readDataFromJson() {
		return customerDataService.readDataFromJson();
	}
	
	@GetMapping(value = "/readDataFromXml", produces = "application/json")
	@ResponseBody
	public List<User> readDataFromXML() {
		return xmlDataService.readXMLFile();
	}

}
