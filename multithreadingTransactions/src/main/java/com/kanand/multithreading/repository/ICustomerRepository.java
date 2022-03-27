package com.kanand.multithreading.repository;

import org.springframework.data.repository.CrudRepository;

import com.kanand.multithreading.entity.CustomerDTO;


public interface ICustomerRepository extends CrudRepository<CustomerDTO, Integer> {

}
