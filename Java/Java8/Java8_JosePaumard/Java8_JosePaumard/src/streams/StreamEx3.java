package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {

	public static void main(String[] args) {

//		an empty stream
		Stream.empty();

//		a singleton stream	
		Stream.of("one");

//		a stream with multiple elements
		Stream.of("one", "two", "three");

//		a constant Stream
		System.out.println("-------Generate---------");
		Stream<String> generate = Stream.generate(() -> "one");
		generate.limit(1).forEach(System.out::println);
		System.out.println("-------Generate---------");

//		a growing Stream
		Stream.iterate("+", s -> s + "+");

//		a random Stream
		System.out.println("----------- Random Streams ----------");
		IntStream ints = ThreadLocalRandom.current().ints();
		ints.limit(5).forEach(System.out::println);
//		ints.limit(5).forEach(System.out::println);
		System.out.println("----------- Random Streams ----------");

//		a Stream on the letters of a String
		IntStream stream = "hello".chars();

//		Stream on the lines of a text file

//		Path path = null;
//		try {
//			Stream<String> lines = Files.lines(path);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		 Stream Builder

		Stream.Builder<String> builder = Stream.builder();

//		by chaining the add method
		builder.add("one").add("two").add("three");

//		or by calling accept()
		builder.accept("four");

//		and use the stream
		Stream<String> stream2 = builder.build();
		stream2.forEach(System.out::println);

//		A built stream will throw an exception on add or accept call after it is build
		
		 

		Person p1 = new Person("Arpit", "Ramashram");
		Person p2 = new Person("Himi", "Ghaziabad");
		Person p3 = new Person("Govind", "Fatehgarh");
		
		List<Person> list = Arrays.asList(p1, p2, p3);
		
		HashMap<String, String> hm = new HashMap<>();
		
//		arrayList to map
		
		Map<String, String> listToMap = list.stream().collect(Collectors.toMap(Person::getName, Person::getDepartment));
		System.out.println("Map is " + listToMap);

//		copying map

		Map<String, String> cloningMap = listToMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
		
		System.out.println("Copying map " + cloningMap);
		
		
	}

}
