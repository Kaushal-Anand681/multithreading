package com.kanand.multithreading.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kanand.multithreading.model.Customer;

@Service
public class CustomerDataService {

	public List<Customer> readDataFromJson() {

		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream fileInputStream = new FileInputStream(new File("src/main/resources/customer-mock.json"));
			TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {
			};
			List<Customer> customerDataList = mapper.readValue(fileInputStream, typeReference);
			return customerDataList;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();

	}

}
