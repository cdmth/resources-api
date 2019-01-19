package com.codemoth.resourcetestapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepo;
	
	List<Test> getTests() {
		return testRepo.findAll();
	}
	
}
