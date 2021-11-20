import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Iterator1 {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(12);
		numbers.add(8);
		numbers.add(2);
		numbers.add(23);
		
		LinkedList<Integer> numbers2 = new LinkedList<Integer>();
		numbers2.add(12);
		numbers2.add(8);
		numbers2.add(2);
		numbers2.add(23);
		
		
		Iterator<Integer> it2 = numbers2.iterator();
		
		while(it2.hasNext()) {
			Integer j = it2.next();
			if(j>2) {
				it2.remove();
			}
			
		}
		System.out.println("***********");
		System.out.println(numbers2);
		System.out.println("***********");
		
		Iterator<Integer> it = numbers.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			if (i < 10) {
				it.remove();
			}
		}
		System.out.println(numbers);

	}

}
