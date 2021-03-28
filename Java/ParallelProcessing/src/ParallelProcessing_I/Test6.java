package ParallelProcessing_I;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test6 {

	public static void main(String[] args) {

		/*
		 * List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		 * 
		 * Optional<Integer> reduce = list.stream().reduce(Integer::sum);
		 * 
		 * list.stream().filter(p -> p > 5);
		 * 
		 * System.out.println(reduce);
		 * 
		 * int a = 5; int b = 3;
		 * 
		 * Difference diff = (p, q) -> { return p - q; };
		 * 
		 * int sub = diff.diff(a, b);
		 * 
		 * System.out.println(sub);
		 */

		Employee emp1 = new Employee("Arpit", 1000);
		Employee emp2 = new Employee("Rahul", 3000);
		Employee emp3 = new Employee("Puneet", 5000);

		List<Employee> empList = Arrays.asList(emp1, emp2, emp3);

		empList.stream().map(p -> p.getSalary()).reduce(Integer::max);

		HashMap<Integer, List<Employee>> hm = new HashMap<>();
		hm.put(1, empList);
		hm.put(2, empList);
		hm.put(1, empList);

		List<Employee> collect = hm.entrySet().stream().filter(e -> e.getKey() == 2).map(Map.Entry::getValue).flatMap(l -> l.stream()).collect(Collectors.toList());

		System.out.println(collect);
	}

}
