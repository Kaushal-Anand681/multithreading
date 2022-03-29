package com.kanand.multithreading.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kanand.multithreading.entity.CustomerDTO;
import com.kanand.multithreading.repository.ICustomerRepository;

@Component
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public boolean save(CustomerDTO customer) {
		return customerRepository.save(customer) != null;
	}

	@Override
	public String delete(Integer id) {
		if(customerRepository.findById(id) != null) {
			customerRepository.deleteById(id);
			return "data deleted";
		}
		return "id not found";
	}

	
}