package com.kanand.multithreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanand.multithreading.entity.UserData;

public interface IUserData extends JpaRepository<UserData , Integer> {

}
