package com.kanand.multithreading.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "usernametoemailmapping")
@Entity
@Data
public class UserNameToEmailMapping {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
}
