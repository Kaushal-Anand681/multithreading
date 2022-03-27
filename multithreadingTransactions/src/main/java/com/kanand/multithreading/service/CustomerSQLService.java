package com.kanand.multithreading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanand.multithreading.dao.CustomerDaoImpl;
import com.kanand.multithreading.entity.CustomerDTO;

@Service
public class CustomerSQLService {
	
	@Autowired
	private CustomerDaoImpl customerRepository;

	public String saveCustomerData(CustomerDTO customer) {
		boolean isSuccess = customerRepository.save(customer);
		if(isSuccess) {
			return "Data Saved SuccessFully";
		}
		return "Something went wrong. Please try again.";
	}
	
	

}
