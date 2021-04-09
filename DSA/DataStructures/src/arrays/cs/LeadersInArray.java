package arrays.cs;

//Print Elements which are greater than all it's right elements
public class LeadersInArray {

	public static void main(String[] args) {

		int a[] = { 2,4,9,22,12,9,4,8};
//		int a[] = { 14, 15, 8, 9, 5, 2};
		
		PrintLeader(a);
		
	}

	private static void PrintLeader(int[] a) {
		int max = Integer.MIN_VALUE;
		
		for(int i=a.length-1; i>=0; i--) {
			if(i==a.length-1) {
				System.out.println(a[i]);
				max=a[i];
			}
			
			if(a[i]>max) {
				max=a[i];
				System.out.println(max);
			}
				
			
	}

	
}
}
