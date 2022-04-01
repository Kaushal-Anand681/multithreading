package com.kanand.multithreading.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kanand.multithreading.entity.CustomerDTO;
import com.kanand.multithreading.model.Customer;
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
		if(customerRepository.existsById(id)) {
			customerRepository.deleteById(id);
			return "data deleted";
		}
		return "id not found";
	}

	public Customer findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
