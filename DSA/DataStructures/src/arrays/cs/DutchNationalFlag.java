package arrays.cs;

import java.util.Arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {

		int a[] = {0,1,1,0,2,2,1,0,2};
		DutchNationalFlag_Func(a);
	}

	private static void DutchNationalFlag_Func(int[] a) {
		
		int low, mid, high;
		low = mid = 0;
		high = a.length-1;
		
		while(mid<=high) {
			switch(a[mid]) {
			
			case 0: 
				if(a[low] != a[mid]) {
					int t = a[low];
					a[low] = a[mid];
					a[mid] = t;
				}
				
				low++;
				mid++;
				break;
				
			case 1:
				mid++;
				break;
								
			case 2:				
				if(a[mid] != a[high]) {
					
					int t = a[mid];
					a[mid] = a[high];
					a[high] = t;
				}
				high--;			
			}
		}		
		System.out.println(Arrays.toString(a));
	}
}
