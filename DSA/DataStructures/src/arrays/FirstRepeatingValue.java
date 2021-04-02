package arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingValue {

	public static void main(String[] args) {

		int a[] = {2,3,3,4,4,3,5,7};
		
		System.out.println(FirstRepeatValue(a));
	}

	private static int FirstRepeatValue(int[] a) {
		Set<Integer> st = new HashSet<>();
		int i = 0;
		while(i < a.length) {
			if(st.contains(a[i])) {
				return a[i];
			}
			else {
				st.add(a[i]);
				i++;
			}
		}
		return -1;
		
		
	}

}
