package com.kanand.multithreading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanand.multithreading.dao.CustomerDaoImpl;
import com.kanand.multithreading.entity.CustomerDTO;
import com.kanand.multithreading.model.Customer;

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

	public String deleteCustomerData(Integer id) {
		return customerRepository.delete(id);
	}
	
	public Customer findById(Integer id) {
		return customerRepository.findById(id);
	}
	
	public List<Customer> findByName(String name) {
		return customerRepository.findByName(name);
	}
	
	

}
