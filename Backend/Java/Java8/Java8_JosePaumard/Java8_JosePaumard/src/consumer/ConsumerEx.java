package consumer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerEx {

	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.of(2020, 02, 02);
		System.out.println(localDate.format(DateTimeFormatter.ofPattern("E, MMM dd, yyyy")));

		List<String> strings = Arrays.asList("one", "two", "three");
		List<String> result = new ArrayList<String>();
		Consumer<String> c1 = System.out::println;

		strings.stream().reduce((x1,x2) -> x1.length()==5? x1:x2).ifPresent(System.out::println);
//		Consumer<String> c2 = s -> result.add(s);
		Consumer<String> c2 = result::add;
		System.out.println("Result is :  " + result);

//		strings.forEach(c1);
		strings.forEach(c1.andThen(c2));
		System.out.println("Result is :  " + result);
		
		System.out.println("**************");
		
		String stringA = "A";
		String stringB = "B";
		
		String stringnull = null;
		
		
		StringBuilder bufferc = new StringBuilder("C");
		
		Formatter fmt = new Formatter(bufferc);
		fmt.format("%s%s", stringA, stringB);
		System.out.println("Line 1 " + fmt);
		
		fmt.format("%-2s", stringB);
		System.out.println("Line 2 " + fmt);
		
		fmt.format("%b", stringnull);
		System.out.println("Line 3 " + fmt);
		
		
		
		

	}

}
