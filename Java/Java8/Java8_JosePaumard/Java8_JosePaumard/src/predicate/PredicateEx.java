package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateEx {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("one", "two", "three");
		Predicate<String> p1 = s -> s.length() > 3;

		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("three");

//		stream.filter(p2.and(p3)).forEach(s-> System.out.println(s));

		List<String> list = new ArrayList<>();

//		stream
//			.peek(System.out::println)
//			.filter(p1.or(p2))
//			.peek(list::add);

		stream.peek(System.out::println).filter(p1.or(p2)).forEach(list::add);

		System.out.println("Done");
		System.out.println("Size " + list.size());

	}

}
