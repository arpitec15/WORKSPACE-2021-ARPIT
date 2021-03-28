package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tesst3 {
	
	

	public static void main(String[] args) {
		
		Employee emp1 = new Employee("A1","A1", 78);
		Employee emp2 = new Employee("B1","B1", 78000);
		
		List<Employee> empList = Arrays.asList(emp1,emp2);
		
		List<Employee> collect = empList.stream()
							.filter(p -> p.getName().startsWith("B"))
							.filter(p -> p.getSalary()>10000)
							.collect(Collectors.toList());
		
//		empList.stream().filter(p -> p.get)

		collect.forEach(p -> System.out.println(p.getName()));
		
//		salaryFilter.forEach(p -> System.out.println(p.getName()));
		
		
		
	}

}
