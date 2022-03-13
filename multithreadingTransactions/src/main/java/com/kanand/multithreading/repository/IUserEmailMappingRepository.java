package com.kanand.multithreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanand.multithreading.entity.UserNameToEmailMapping;

public interface IUserEmailMappingRepository extends JpaRepository<UserNameToEmailMapping , Integer> {

}
