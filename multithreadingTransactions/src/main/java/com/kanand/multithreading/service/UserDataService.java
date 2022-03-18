package com.kanand.multithreading.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanand.multithreading.model.ConnectionConfigProperties;
import com.kanand.multithreading.model.Customer;

@Service
public class UserDataService {

	@Autowired
	private ConnectionConfigProperties connectionConfigProperties;
	/*
	 * @Autowired private TaskExecutor taskExecutor;
	 * 
	 * @Autowired private IUserData userDataRepo;
	 * 
	 * public String saveUserData(UserData user) { // main thread bluff response ->
	 * in progress Runnable r = () -> { // child thread actual response -> running
	 * userDataRepo.save(user); // if(child thread actual response == Error ||
	 * success) // child thread actual response -> competed || error };
	 * taskExecutor.execute(r); return "InProgress"; }
	 */

	public boolean checkUrl(String urlString) {
		URLConnection connection = null;
		try {
			URL url = new URL(urlString);
			connection = url.openConnection();
			if (connection != null) {
				connection.connect();
			} else {
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

	public String readDataFromProperties() {
		return connectionConfigProperties.getEmail("email");
	}

	public List<Customer> readDataFromCSV() {
		List<Customer> customerList= new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/MOCK_DATA.csv"));
			try {
				while(bufferedReader != null && bufferedReader.readLine() != null) {
					String [] data = bufferedReader.readLine().split(",");
					Customer customer = new Customer();
					customer.setId(Integer.parseInt(data[0]));
					customer.setFirstName(data[1]);
					customer.setLastName(data[2]);
					customer.setEmail(data[3]);
					customer.setGender(data[4]);
					customer.setOrderQuantity(Integer.parseInt(data[5]));
					customerList.add(customer);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return customerList;
	}

}
