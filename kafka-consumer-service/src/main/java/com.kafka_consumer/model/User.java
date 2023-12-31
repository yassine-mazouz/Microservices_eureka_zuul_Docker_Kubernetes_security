package com.kafka_consumer.model;

public class User {

	
	private String name;
	private int age;
	private long salary;
	
	public User(String name, int age, long salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public User() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
}
