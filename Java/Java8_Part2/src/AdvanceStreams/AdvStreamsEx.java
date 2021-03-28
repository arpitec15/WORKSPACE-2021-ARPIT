package AdvanceStreams;

import java.util.Spliterator;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.lang.model.util.Elements;

public class AdvStreamsEx {

	public static void main(String[] args) {

//		Concatenating Streams
//		Concat, FlatMap
//   1. CONCAT
//		Concat can only take 2 arguments at a time.
//		Documentation says that elements of the first stream are followed by all the elements of the second stream.
//		Order is preserved, which has cost.
//		has problems in parallelism

		Stream<Integer> stream1 = Stream.of(1, 2, 4, 5);
		Stream<Integer> stream2 = Stream.of(5, 4, 0, 9, 10);
		
//		System.out.println("Stream 1 - " + stream1.count());
//		System.out.println("Stream 2 - " + stream2.count());
//		
//		Stream<Stream<Integer>> streams = Stream.of(stream1, stream2);
//		System.out.println("Streams - " + streams.count());
		
//		Stream.of(s1, s2, s3);
//		It has 3 Elements. This is not concatenation
		
//	2.  FLATMAP
//		It takes a Function. It is just like a regular mapping.
//		Can be used as a regular mapper
//		Resulting stream will be flattened
		
//		Input - Stream<Stream<String>>
//		Output - Stream<String>
		
		Stream<Stream<Integer>> combinedStreams = Stream.of(stream1, stream2);
										 
		Stream<Integer> afterFlatMap = combinedStreams.flatMap(Function.identity());
		System.out.println("After flatMap " + afterFlatMap.count());
		
//	3.	Now we want to merge the lines of two files into one Stream.
		
//		Pattern.compile(""); will help
//		splitAsStream(line)
		
//		Stream<Integer> merge= Stream.of(stream1, stream2) 
//				.flatMap(Function.identity())
//				.flatMap(splitIntoWords)
//				.collect(Collectors.toSet());
		
		
//	4.  State of a stream
		
//		A stream has a state.
		
//		characteristics() method for ArrayList
//		public int characteristics() {
//			return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;  
//		}
		
//		ORDERED - order matters
//		DISTINCT
//		SORTED
//		SIZED - size is known (bounded stream)
//		NONNULL - no null values
//		IMMUTABLE 
//		CONCURRENT - parallelism is possible
//		SUBSIZED - size is known
		
		
	}

}
