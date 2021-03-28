package methodReferences;

import java.util.Comparator;

public class MethodRef {

	public static void main(String[] args) {
		
//		Lambda Expression

		Comparator<Integer> c = (i1,i2) -> Integer.compare(i1,i2);

		
//		Method References
		
		Comparator<Integer> c1 = Integer::compare;
		
		
		
		
		
	}

}
