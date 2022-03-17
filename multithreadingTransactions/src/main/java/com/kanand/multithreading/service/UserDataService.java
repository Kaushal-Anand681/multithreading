package com.kanand.multithreading.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
	
	public boolean checkUrl(String urlString) {
		URLConnection connection = null;
		try {
			URL url = new URL(urlString);
			connection = url.openConnection();
			if(connection != null) {
				connection.connect();
			}else {
				return false;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
}
