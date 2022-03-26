package com.kanand.multithreading.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.kanand.multithreading.dto.User;
import com.kanand.multithreading.dto.Users;

@Service
public class ReadYAMLFileService {

	public Users readYAMLFile() {
		Users users = new Users();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("src/main/resources/users-data.yaml"));
			Yaml yaml = new Yaml(new Constructor(Users.class));
			users = yaml.load(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

}
