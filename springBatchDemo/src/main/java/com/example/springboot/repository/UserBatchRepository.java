package com.example.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.UserBatch;

public interface UserBatchRepository extends JpaRepository<UserBatch, Integer> {

	//void save(List<? extends UserBatch> users);
	

}
