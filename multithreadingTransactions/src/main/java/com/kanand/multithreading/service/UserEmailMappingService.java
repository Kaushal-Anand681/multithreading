package com.kanand.multithreading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.kanand.multithreading.repository.IUserEmailMappingRepository;

@Service
public class UserEmailMappingService {
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	@Autowired
	private IUserEmailMappingRepository userEmailMappingRepository;

	public String getUserEmailByName(String name) {
		
		Runnable r = () -> {
			
		};
		taskExecutor.execute(r);
		return "Done";
	}
}
