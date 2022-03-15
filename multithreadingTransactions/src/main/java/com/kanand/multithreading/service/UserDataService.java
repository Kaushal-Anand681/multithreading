package com.kanand.multithreading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.kanand.multithreading.entity.UserData;
import com.kanand.multithreading.repository.IUserData;

@Service
public class UserDataService {
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	@Autowired
	private IUserData userDataRepo;

	public String saveUserData(UserData user) {
//		main thread bluff response -> in progress
		Runnable r = () -> {
//			child thread actual response -> running
			userDataRepo.save(user);
//			if(child thread actual response == Error || success)
//			child thread actual response -> competed || error
		};
		taskExecutor.execute(r);
		return "InProgress";
	}
}
