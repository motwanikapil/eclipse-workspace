package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {}
record Address(String firstLine, String city) {}

@Configuration // this indicates that this is a spring configuration class
public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "Kapil";
	}
	
	@Bean
	public int age() {
		return 24;
	}
	
	@Bean
	public Person person() {
		var person = new Person("ABC", 20, new Address("Shaitan Gali, Khatra Mahel", "Shamshan ke saamne"));
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address2) { //name, age, address2
		// these values are added by spring
		return new Person(name, age, address2);
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address2) { //name, age, address2
		// these values are added by spring
		return new Person(name, age, address2);
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) { 
		//name, age, address2
		// these values are added by spring
		return new Person(name, age, address);
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		var address = new Address("Hitech City", "Hyderabad");
		return address;
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		var address = new Address("Motinagar", "Vadodara");
		return address;
	}
}
