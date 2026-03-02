package com.in28minutes.learn_spring_aop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.in28minutes.learn_spring_aop.aopexample.data.DataService2;

// same as component but we are in a business service to it is better to use this @Service
@Service
public class BusinessService2 {
	private DataService2 dataService2;
	
	public BusinessService2(DataService2 dataService2) {
		super();
		this.dataService2 = dataService2;
	}

	public int calculateMin() {
		int[] data = dataService2.retriveData();
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		throw new RuntimeException("Something went wrong!");
		return Arrays.stream(data).min().orElse(0);
	}
//	business logic
//	data 
}
