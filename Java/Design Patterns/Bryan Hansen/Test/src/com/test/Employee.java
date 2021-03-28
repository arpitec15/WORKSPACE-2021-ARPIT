package com.test;

public class Employee {

	private String name;
	private String id;
	private Integer salary;

	public Employee(String id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String i) {
		this.id = i;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
