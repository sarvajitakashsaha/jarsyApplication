package com.example.springboot.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.springboot.model.UserBatch;
@Component
public class Processor implements ItemProcessor<UserBatch, UserBatch> {
	Map<String, String> DEPT_NAMES = new HashMap<String, String>();

	private Processor() {
		DEPT_NAMES.put("1","java");
		DEPT_NAMES.put("2","datastructure");
		DEPT_NAMES.put("3","spring boot");
	}

	@Override
	public UserBatch process(UserBatch user) throws Exception {
		System.out.println(" before processing in processor :: " + user);
		String deptCode = user.getDept();
		String dept = DEPT_NAMES.get(deptCode);
		user.setDept(dept);
		System.out.println(" After processing in processor :: " + user);
		return user;
	}

}
