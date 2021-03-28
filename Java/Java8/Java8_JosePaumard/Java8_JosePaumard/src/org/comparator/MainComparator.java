package org.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MainComparator{

	public static void main(String[] args) {
		Person pp1 = new Person("E", "Z", 88);
		Person pp2 = new Person("C", "D", 8);
		List<Person> personList = new LinkedList<>();
		personList.add(pp1);
		personList.add(pp2);

		List<Person> list = Arrays.asList(pp1,pp2);
		Comparator<Person> cmpAge1 = (p1,p2) -> p2.getAge() - p1.getAge();
		MyComparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
		MyComparator<Person> cmpFirstName = (p1, p2) -> p2.getFirstName().compareTo(p1.getFirstName());
		MyComparator<Person> cmpLastName = (p1, p2) -> p2.getLastName().compareTo(p1.getLastName());

		Function<Person, Integer> f1 = p -> p.getAge();
		Function<Person, String> f2 = p -> p.getLastName();
		Function<Person, String> f3 = p -> p.getFirstName();

//		MyComparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
//		MyComparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);
//		MyComparator<Person> cmpPersonFirstName = Comparator.comparing(Person::getFirstName);

		MyComparator<Person> cmp = MyComparator.comparing(Person::getLastName).thenMyComparing(Person::getFirstName)
				.thenMyComparing(Person::getAge);
 
		
//		personList.sort(cmp);
		Stream<Person> sorted = personList.stream().sorted(cmp);
		sorted.forEach(p -> System.out.println(p.getLastName()));
		
	}

}
