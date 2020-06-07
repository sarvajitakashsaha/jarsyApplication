package com.example.springboot.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springboot.model.UserBatch;
import com.example.springboot.repository.UserBatchRepository;

@Component
public class DBWritter implements ItemWriter<UserBatch> {
	@Autowired
	UserBatchRepository userBatchRepository;

	@Override
	public void write(List<? extends UserBatch> users) throws Exception {
		System.out.println("data users :: " + users);
		userBatchRepository.saveAll(users);
	}

}
