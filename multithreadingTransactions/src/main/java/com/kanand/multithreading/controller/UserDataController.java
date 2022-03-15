package com.kanand.multithreading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kanand.multithreading.entity.UserData;
import com.kanand.multithreading.service.UserDataService;

@RestController
public class UserDataController {
	
	@Autowired
	private UserDataService userDataService;
	
	@PostMapping(value = "/saveUserData", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String saveUserData(UserData user) {
		return userDataService.saveUserData(user);
	}
//	checksyncStatus

}
