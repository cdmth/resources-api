package com.codemoth.resourcetestapi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_table")
public class Test {

	@Id
	private Integer id;
	
	public Test() {
		
	}
	
	public Test(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
}
