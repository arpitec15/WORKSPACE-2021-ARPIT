// Find max multiplication of any two numbers in array
// Input :  int arr2[] = {4,1,2,7,3};
// Output: 28

package arrays.cs;
import java.util.TreeSet;

public class MaxMultiplicationOfTwoNumbers {

	public static void main(String[] args) {
	    int arr2[] = {4,1,2,7,3};
	  
	    System.out.println(maxMultiplicationTwoNumbers(arr2));
	}

	private static int maxMultiplicationTwoNumbers(int[] arr) {
				
		TreeSet<Integer> ts = new TreeSet<Integer>(); 
		int i=0;
		
		while(i<arr.length) {
			ts.add(arr[i]);
			i++;			
		}
		
		Integer[] intArray = ts.toArray(new Integer[ts.size()]);		
		int l = intArray.length;		
		int mul = intArray[l-2] * intArray[l-1];
		return mul;
		}
}
