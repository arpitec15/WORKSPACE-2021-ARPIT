package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx2 {

	public static void main(String[] args) {

		Person p1 = new Person("Arpit", "Agra");
		Person p2 = new Person("Himi", "Ghaziabad");
		
		List<Person> personList = Arrays.asList(p1,p2);
		
//		1. Stream
		List<String> collect = personList.stream()
				  .map(p -> p.getDepartment())
				  .filter(p -> p.equalsIgnoreCase("Ghaziabad"))
				  .collect(Collectors.toList());
		
//		collect.forEach(System.out::println);
		
		
//		personList.stream()
//				  .filter(p -> p.department.equalsIgnoreCase("Ghaziabad"))
//				  .forEach(p -> System.out.println(p.name));
		
		
//		2. Peek
//		peek is an intermediate operation and is only used for debugging purpose
//		for each is an terminal operation
		
//		Intermediate call : a call that returns a stream
//		Terminal call : a call that returns void or something else and 
//						triggers processing
		
		
		personList.stream()
				  .map(p -> p.getDepartment())
				  .peek(p -> System.out.println("Peek " + p))
				  .filter(p -> p.equalsIgnoreCase("Ghaziabad"))
				  .forEach(System.out::println);
		
		
//		3. skip() and limit()
		
//		personList.stream()
//				  .skip(1)
//				  .limit(3)
//				  .filter(p -> p.getDepartment().contains("G"))
//				  .forEach(System.out::println);
		
		
//		4. Match Reduction
		
//		4(a) anyMatch()
//		4(b) allMatch()
//		4(c) noneMatch()
		
		

		
		
		
		
//		5. Find Reduction
		
//		5(a) findFirst()
//		5(b) findAny
		
//		Both returns Optional, that can be empty
		
		
		
		
		
		
		
		
		
		
		
//		6. Reduce Reduction
//		6(a) No identity element is provided, then an Optional is returned
//		6(b) identity element is provided, then an Optional is returned
//		6(c) Identity element, Accumulator, Combine are provided. Used in parallel operations
		
		
		
		
		
	}

}