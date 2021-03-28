package spliterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorEx {

	public static void main(String[] args) {
		
//		1. Spliterator? Object on which a stream is built.

//		Collection.stream()
//		 default Stream<E> stream() {
//		        return StreamSupport.stream(spliterator(), false);
//		    }
		
//		New interface in Java 8, 
//		that models the access the data for a Stream
		
//		 default Spliterator<E> spliterator() {
//		     return Spliterators.spliterator(this, 0);
//		    }

		
//		A stream is divided in two things:
//		An object to access the data, this is the Spliterator
//			- It is meant to be overriden to suit our needs
			
//		Can we build our own Spliterator?
//				- Yes
				
		
		
	}

}
