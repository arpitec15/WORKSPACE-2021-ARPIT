package arrays.cs;

public class BinarySearch {

	public static void main(String[] args) {
//		Condition 
//		Array should be sorted
		
		int a[] = {2,6,9,11,15,18,19,22,90};
		
		int index = BinarySearchFunc(a, 2, 0, a.length-1);
		if(index == -1) {
			System.out.println("Value doesn't exists");
		}
		else {
			System.out.println("Value found at " + index);
		}
	}

	private static int BinarySearchFunc(int[] a, int x, int start, int end) {
		
		if(a.length==0 || start > end)
			return -1;
		
		if(start == end)
			return end;
		
		int mid = (start + end) / 2;
		
		if(x == a[mid]) {
			return mid;
		}
		
		if(x<a[mid]) {
			return BinarySearchFunc( a, x, start , mid -1);
			
		}
		else {
			return BinarySearchFunc( a, x, mid+1 , end);
		}
	}
	
	

}
