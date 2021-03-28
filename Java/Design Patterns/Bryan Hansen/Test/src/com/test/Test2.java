package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {

	public static void main(String[] args) {

		Employee emp1 = new Employee("11", "A1", 99);
		Employee emp2 = new Employee("12", "B1", 199);

		List<Employee> empList = Arrays.asList(emp1, emp2);
		Stream<Employee> filter = empList.stream()
										 .filter(p -> p.getName().startsWith("A1"));

		filter.forEach(p -> System.out.println(p.getName()));
		
//		squares of numbers
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);		
		List<Integer> squares = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("Squares are "+squares);
		
		
	}

}
