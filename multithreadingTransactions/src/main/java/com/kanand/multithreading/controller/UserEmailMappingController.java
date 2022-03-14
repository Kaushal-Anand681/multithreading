package com.kanand.multithreading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanand.multithreading.service.UserEmailMappingService;

@RestController
public class UserEmailMappingController {
	
	@Autowired
	private UserEmailMappingService userEmailMappingService;
	
	@PostMapping(value = "/getUserEmail", produces = "application/json")
	public ResponseEntity<Object> getUserEmailByName(@PathVariable(value="name") String name ) {
		String email = userEmailMappingService.getUserEmailByName(name);
		return new ResponseEntity<>(email, HttpStatus.OK);
	}

}
