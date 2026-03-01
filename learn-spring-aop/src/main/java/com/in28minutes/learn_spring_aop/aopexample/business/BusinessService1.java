package com.in28minutes.learn_spring_aop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.in28minutes.learn_spring_aop.aopexample.data.DataService1;

// same as component but we are in a business service to it is better to use this @Service
@Service
public class BusinessService1 {
	private DataService1 dataService1;
	
	public BusinessService1(DataService1 dataService1) {
		super();
		this.dataService1 = dataService1;
	}



	public int calculateMax() {
		int[] data = dataService1.retriveData();
		return Arrays.stream(data).max().orElse(0);
	}
//	business logic
//	data 
}
