package AdvanceStreams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

import spliterator.Person;

public class StreamOfNumbers {

	public static void main(String[] args) {
		
		Person p1 = new Person("Arpit", 28, "Ghaziabad");
		Person p2 = new Person("Himi", 28, "Agra");
		
		List<Person> personList = Arrays.asList(p1,p2);
		IntStream streamOfInts = personList.stream().mapToInt(Person::getAge);
		
//		OptionalDouble average = streamOfInts.average();
		IntSummaryStatistics summaryStatistics = streamOfInts.summaryStatistics();

//		System.out.println("Average " + average);
		System.out.println("Summary Statistics "+ summaryStatistics);
	}

}
