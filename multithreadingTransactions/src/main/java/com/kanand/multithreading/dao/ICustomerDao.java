package com.kanand.multithreading.dao;

import com.kanand.multithreading.entity.CustomerDTO;

public interface ICustomerDao {
	
	public boolean save(CustomerDTO customer);

}
