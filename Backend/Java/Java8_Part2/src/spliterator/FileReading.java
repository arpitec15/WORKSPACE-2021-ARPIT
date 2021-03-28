package spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FileReading {

	public static void main(String[] args) {

		Path path = Paths.get("src/file1.txt");

		try {
			Stream<String> lines = Files.lines(path);
			Spliterator<String> lineSpliterator = lines.spliterator();
			Spliterator<Person> personSpliterator = new PersonSpliterator(lineSpliterator);

			Stream<Person> person = StreamSupport.stream(personSpliterator, false);

			person.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
