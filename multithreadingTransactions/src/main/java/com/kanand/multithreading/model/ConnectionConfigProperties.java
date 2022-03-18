package com.kanand.multithreading.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:connection-config.properties")
public class ConnectionConfigProperties {
	
	@Autowired
    private Environment env;
	
	public String getEmail(String key) {
		return env.getProperty(key);
	}

}
