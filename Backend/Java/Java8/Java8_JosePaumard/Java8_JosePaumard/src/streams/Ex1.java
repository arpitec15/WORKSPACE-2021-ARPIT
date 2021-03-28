package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex1 {

	public static void main(String[] args) {

		Person2 p1 = new Person2("Arpit", "Shrivastava", "ECE");
		Person2 p2 = new Person2("Himi", "Om", "ECE");
		Person2 p3 = new Person2("Arpit", "Shrivastava", "ECE");

		List<Person2> list = Arrays.asList(p1, p2, p3);

//		Sort list by last name

		Comparator<Person2> sortByLastName = (Person2 o1, Person2 o2) -> o2.getLastName().compareTo(o1.getLastName());
		list.sort(sortByLastName);

//		Create a method which prints all the elements in the list
		printAllElements(list);

//		Create a method that prints all people that have last name beginning with O

		Predicate<Person2> predicate = p -> p.getLastName().startsWith("O");
		Consumer<Person2> consumer = System.out::println;
		printAllElementsWithO(list, predicate, consumer);

	}

	public static void printAllElements(List<Person2> list) {

		System.out.println("----printAllElements----");
		list.stream().forEach(System.out::println);
	}

	public static void printAllElementsWithO(List<Person2> list, Predicate<Person2> predicate, Consumer<Person2> consumer) {

		System.out.println("----printAllElementsWithO-----");
//		list.stream().map(p -> p.getLastName()).filter(p -> p.startsWith("O")).forEach(System.out::println);
		list.stream().filter(predicate).forEach(consumer);
	}
}
