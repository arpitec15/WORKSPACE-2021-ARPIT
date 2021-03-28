package reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ReduceEx {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,77);
		
//		Sum
		Integer sum = list.stream().
				reduce(0, Integer::sum);
		
		
//		Max
		Optional<Integer> max = list.stream().
				reduce(Integer::max);
		
		System.out.println("sum " + sum);
		System.out.println("max " + max);
		
//		Mutable Reduction
		
		
		Person p1 = new Person();
		p1.name = "Arpit";
		p1.department = "ECE IT";
		
		Person p2 = new Person();
		p2.name = "Pranjili";
		p2.department = "MBA";
		
		Person p3 = new Person();
		p3.name = "Chutki";
		p3.department = "MBA";
		
		List<Person> persons = new ArrayList<>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		
		Optional<Person> person = persons.stream()
									.filter(p -> p.getName().length()>2)
									.min(Comparator.comparing(Person::getName));
		
		System.out.println("Person is " + person);
		
		
		Map<String, List<Person>> map =
				persons.stream()
				.collect(Collectors.groupingBy(Person::getDepartment));
			
		
		System.out.println(" Map is " + map);
		
		Map<String, Long> map2 =
				persons.stream()
				.collect(Collectors.groupingBy(
						Person::getDepartment,
						Collectors.counting()
						)
				);
		
		System.out.println("Downstream collector " + map2);
		
		Map<String, List<String>> map3 =
				persons.stream()
				.collect(Collectors.groupingBy(
						Person::getDepartment,
						Collectors.mapping(
								Person::getName,
								Collectors.toList()
								)
						)
						);
		
		System.out.println("Downstream collector 2 " + map3);

		Map<String, Set<String>> map4 =
				persons.stream()
				.collect(Collectors.groupingBy(
						Person::getDepartment,
						Collectors.mapping(
								Person::getName,
								Collectors.toCollection(TreeSet::new)
								)
						)
						);
		
		System.out.println("Downstream collector 3 " + map4);
		
		Map<String, String> map5 =
				persons.stream()
				.collect(Collectors.groupingBy(
						Person::getDepartment,
						Collectors.mapping(
								Person::getName,
								Collectors.joining(", ")
								)
						)
						);
		
		System.out.println("Downstream collector 4 " + map5);
	}
}
