package com.kanand.multithreading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanand.multithreading.repository.IUserEmailMappingRepository;

@Service
public class UserEmailMappingService {
	
	@Autowired
	private IUserEmailMappingRepository userEmailMappingRepository;
}
