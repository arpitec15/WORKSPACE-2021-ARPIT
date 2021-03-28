import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.test.Employee;

public class xyz {

	public static void main(String[] args) {

		Employee emp1 = new Employee("11", "A1", 99);
		Employee emp2 = new Employee("12", "B2", 199);

		List<Employee> empList = Arrays.asList(emp1, emp2);

		Stream<Employee> salAbove99 = empList.stream().filter(p -> p.getSalary() > 99);
		Stream<Employee> nameMatch = empList.stream().filter(p -> p.getName().startsWith("A"));
		List<Integer> idMatch = empList.stream().filter(p -> p.getName().startsWith("A")).map(i -> i.getSalary()*1000)
				.collect(Collectors.toList());
		

//		salAbove99.forEach(p -> System.out.println(p.getName()));
//		nameMatch.forEach(p -> System.out.println(p.getId()));
//		System.out.println(idMatch);

//		for (Employee employee : empList) {
//			if (employee.getName().startsWith("A")) {
//				System.out.println("Out " + employee.getName());
//			}
//
//		}
		
		List<String> fruits = Arrays.asList("Orangessssss", "Applesss", "Lemon");
		List<String> collect = fruits.stream().sorted((i1,i2) -> -(i1.length() - i2.length())).collect(Collectors.toList());
		System.out.println(collect);
		
		List<Integer> numbers = Arrays.asList(1,2,5,6,7,33,3,666,10);
		Integer min = numbers.stream().min((i1,i2) -> i1.compareTo(i2)).get();
		System.out.println("Minimum is " + min);
		
		

	}

}
